package com.xinxi11.module.core.orm.hibernate.listener;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinxi11.module.core.entity.RecordSupport;

/**
 * 
 * hibernate 拦截器
 */
public class HistoryListener implements PostInsertEventListener, PostUpdateEventListener,
		PostDeleteEventListener, PreUpdateEventListener {

	private static final long serialVersionUID = 1L;
	private Logger log = LoggerFactory.getLogger(getClass());

	private static final String SAVE = "新建";
	private static final String UPDATE = "更新";
	private static final String DELETE = "删除";

	@Override
	public void onPostInsert(PostInsertEvent event) {
		if (event.getEntity() instanceof Historizable) {
			Historizable entity = (Historizable) event.getEntity();
			HistoryEntry entry = new HistoryEntry();
			entry.setOperationType(SAVE);
			entry.setTimestamp(new Date());
			entry.setHistorizableEntity(entity);
			log.debug(entry.toString());
			recordHistory(event.getSession(), entry);
		}
	}

	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		if (event.getEntity() instanceof Historizable) {
			for (int i = 0; i < event.getState().length; i++) {
				// 更新前的值
				Object oldValue = event.getOldState()[i];
				// 更新后的新值
				Object newValue = event.getState()[i];
				// 跳过集合属性
				if (newValue instanceof PersistentCollection) {
					continue;
				}
				if (oldValue != null && !oldValue.equals(newValue)) {
					HistoryEntry entry = new HistoryEntry();
					// 取得属性名称
					entry.setProperty(event.getPersister().getPropertyNames()[i]);
					entry.setOperationType(UPDATE);
					// 如果更改的属性是关联对象，则存储其id
					if (oldValue instanceof RecordSupport<?>) {
						entry.setPreviousValue(((RecordSupport<?>) oldValue).getId().toString());
					} else {
						entry.setPreviousValue(oldValue.toString());
					}
					if (newValue instanceof RecordSupport<?>) {
						entry.setNewValue(((RecordSupport<?>) newValue).getId().toString());
					} else {
						entry.setNewValue(newValue != null ? newValue.toString() : null);
					}
					entry.setTimestamp(new Date());
					entry.setHistorizableEntity((Historizable) event.getEntity());
					log.debug(entry.toString());
					recordHistory(event.getSession(), entry);
				}
			}
		}
	}

	@Override
	public void onPostDelete(PostDeleteEvent event) {
		if (event.getEntity() instanceof Historizable) {
			HistoryEntry entry = new HistoryEntry();
			entry.setOperationType(DELETE);
			entry.setTimestamp(new Date());
			entry.setHistorizableEntity((Historizable) event.getEntity());
			log.debug(entry.toString());
			recordHistory(event.getSession(), entry);
		}
	}

	// 另外启动一个session处理审核日志的保存
	private void recordHistory(Session session, HistoryEntry entry) {
		Session tempSession = session.getSessionFactory().openSession();
		Transaction tx = tempSession.beginTransaction();
		try {
			tx.begin();
			tempSession.save(entry);
			tempSession.flush();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		tempSession.close();
	}

	@Override
	public boolean onPreUpdate(PreUpdateEvent event) {
		if (event.getEntity() instanceof Historizable) {
			for (int i = 0; i < event.getState().length; i++) {
				// 更新前的值
				Object oldValue = event.getOldState()[i];
				// 更新后的新值
				Object newValue = event.getState()[i];
				// 跳过集合属性
				if (newValue instanceof PersistentCollection) {
					continue;
				}
				if (oldValue != null && !oldValue.equals(newValue)) {
					HistoryEntry entry = new HistoryEntry();
					// 取得属性名称
					entry.setProperty(event.getPersister().getPropertyNames()[i]);
					entry.setOperationType(UPDATE);
					// 如果更改的属性是关联对象，则存储其id
					if (oldValue instanceof RecordSupport<?>) {
						entry.setPreviousValue(((RecordSupport<?>) oldValue).getId().toString());
					} else {
						entry.setPreviousValue(oldValue.toString());
					}
					if (newValue instanceof RecordSupport<?>) {
						entry.setNewValue(((RecordSupport<?>) newValue).getId().toString());
					} else {
						entry.setNewValue(newValue != null ? newValue.toString() : null);
					}
					entry.setTimestamp(new Date());
					entry.setHistorizableEntity((Historizable) event.getEntity());
					log.debug(entry.toString());
					recordHistory(event.getSession(), entry);
				}
			}
		}
		return false;
	}
}