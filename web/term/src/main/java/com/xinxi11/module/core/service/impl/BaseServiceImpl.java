package com.xinxi11.module.core.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinxi11.module.core.cache.LoginUserInfo;
import com.xinxi11.module.core.entity.IEntity;
import com.xinxi11.module.core.entity.IQueryBean;
import com.xinxi11.module.core.entity.RecordSupport;
import com.xinxi11.module.core.orm.Finder;
import com.xinxi11.module.core.orm.Pagination;
import com.xinxi11.module.core.orm.hibernate.IHibernateDao;
import com.xinxi11.module.core.service.IBaseService;
import com.xinxi11.module.core.spring.SpringContextHolder;

/**
 * 
 */
@Service("baseService")
public class BaseServiceImpl implements IBaseService {

	protected Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 抽象的基础dao
	 */
	@Autowired
	protected IHibernateDao hibernateEntityDao;

	public <T extends IEntity<?>> boolean delete(Serializable ids[],
			Class<T> clazz) {
		for (Serializable id : ids) {
			if (id != null) {
				hibernateEntityDao.deleteById(id, clazz);
			}
		}
		return true;
	}

	@Override
	public <T extends IEntity<?>> boolean delete(Serializable id, Class<T> clazz) {
		hibernateEntityDao.deleteById(id, clazz);
		return true;
	}

	@Override
	public <T extends IEntity<?>> boolean deleteActive(
			Collection<Serializable> ids, Class<T> clazz) {
		Set<Serializable> setIds = new HashSet<Serializable>();
		List<Long> longIds = new ArrayList<Long>();
		// 逻辑删除数据的个数
		int size = 0;
		for (Serializable id : ids) {
			if (null != id) {
				setIds.add(id);
				try {
					longIds.add(Long.valueOf(id.toString()));
				} catch (Exception e) {
				}
				size++;
			}
		}
		Finder finder = new Finder("update " + clazz.getSimpleName());
		finder.append(" set active=1 ");
		try {
			if (clazz.newInstance() instanceof RecordSupport<?>) {
				finder.append(" ,updatePerson=:person ").append(
						" ,updateTime=:updateTime ");
				finder.setParam("person", getLoginUserInfo().getUserName());
				finder.setParam("updateTime", Calendar.getInstance().getTime());
			}
		} catch (InstantiationException e1) {
			log.error(e1.getMessage(), e1);
		} catch (IllegalAccessException e1) {
			log.error(e1.getMessage(), e1);
		}
		finder.append(" where id in (:ids) ");
		finder.setParam("ids", setIds);
		try {
			return size == hibernateEntityDao.executeUpdate(finder);
		} catch (Exception e) {
			finder.setParam("ids", longIds);
			return size == hibernateEntityDao.executeUpdate(finder);
		}

	}

	@Override
	public <T extends IEntity<?>> boolean deleteActive(Serializable id,
			Class<T> clazz) {
		Finder finder = new Finder("update " + clazz.getSimpleName());
		finder.append(" set active=1 ");
		try {
			if (clazz.newInstance() instanceof RecordSupport<?>) {
				finder.append(" ,updatePerson=:person ").append(
						" ,updateTime=:updateTime ");
				finder.setParam("person", getLoginUserInfo().getUserName());
				finder.setParam("updateTime", Calendar.getInstance().getTime());
			}
		} catch (InstantiationException e) {
			log.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		}
		finder.append(" where id = (:ids) ").setParam("ids", id);
		return 1 == hibernateEntityDao.executeUpdate(finder);
	}

	@Override
	public <T extends IEntity<?>> T findById(Serializable id, Class<T> clazz) {
		return hibernateEntityDao.findById(id, clazz);
	}

	@Override
	public <X> X findByQueryBean(IQueryBean querybean) {
		return hibernateEntityDao.queryForObject(querybean.getQueryFinder());
	}

	@Override
	public <T extends IEntity<?>> Serializable save(T t) {
		if (t instanceof RecordSupport<?>) {
			RecordSupport<?> record = (RecordSupport<?>) t;
			record.setCreatePerson(getLoginUserInfo().getUserName());
			record.setCreateTime(Calendar.getInstance().getTime());
		}
		return hibernateEntityDao.save(t);
	}

	@Override
	public <T extends IEntity<?>> void save(List<T> listEntity) {
		for (T entity : listEntity) {
			save(entity);
		}
	}

	@Override
	public <T extends IEntity<?>> boolean update(T t) {
		if (t instanceof RecordSupport<?>) {
			RecordSupport<?> record = (RecordSupport<?>) t;
			record.setUpdatePerson(getLoginUserInfo().getUserName());
			record.setUpdateTime(Calendar.getInstance().getTime());
		}
		hibernateEntityDao.update(t);
		return true;
	}

	@Override
	public <X> List<X> findByQueryBean(IQueryBean querybean, Pagination page) {
		return hibernateEntityDao
				.queryForList(querybean.getQueryFinder(), page);
	}

	/** 获取当前使用登记的信息 */
	protected LoginUserInfo getLoginUserInfo() {
		return SpringContextHolder.getCacheUser().findCacheUser(
				SpringContextHolder.getLoginUserId());
	}

}
