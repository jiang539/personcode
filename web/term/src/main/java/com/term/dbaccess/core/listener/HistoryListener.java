package com.term.dbaccess.core.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;

import com.term.dbaccess.core.entity.Auditable;

/**
 * Hibernate的审计日志类 实现了Hibernate监听接口 提供了对数据库Auditable接口类型的Entity的监听，记录增删改的日志
 */
public class HistoryListener implements PostInsertEventListener,
		PostDeleteEventListener, PreUpdateEventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(HistoryListener.class);
	private static final String UPDATE = "更新";
	private static final String DELETE = "删除";
	private static final String SAVE = "保存";

	/**
	 * 添加时记录日志
	 */
	@Override
	public void onPostInsert(PostInsertEvent event) {
		Object entity = event.getEntity();
		if (entity instanceof Auditable) {
			// 保存 插入日志
			saveLog((Auditable) entity, event.getPersister().getFactory(), SAVE);

		}
	}

	/**
	 * 删除时记录日志
	 */
	@Override
	public void onPostDelete(PostDeleteEvent event) {
		Object entity = event.getEntity();
		if (entity instanceof Auditable) {
			// 保存 删除日志
			saveLog((Auditable) entity, event.getPersister().getFactory(), SAVE);

		}
	}

	/**
	 *修改前记录修改日志
	 * 
	 * 
	 * @param event
	 * @return
	 */
	@Override
	public boolean onPreUpdate(PreUpdateEvent event) {
		Object entity = event.getEntity();
		if (entity instanceof Auditable) {
			saveLog((Auditable) entity, event.getPersister().getFactory(), SAVE);

		}
		return false;
	}

	/**
	 * 组装日志entity
	 * 
	 * @param auditable
	 * @param sessionFactory
	 * @param operationTyep
	 * @return
	 */
	private Object saveLog(Auditable auditable, SessionFactory sessionFactory,
			String operationTyep) {
		
		auditable.toString();
		return null;
	}
}