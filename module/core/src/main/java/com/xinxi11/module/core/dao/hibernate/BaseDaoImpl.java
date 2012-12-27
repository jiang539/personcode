package com.xinxi11.module.core.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinxi11.module.core.dao.Finder;
import com.xinxi11.module.core.dao.IBaseDao;
import com.xinxi11.module.core.dao.Pagination;

@SuppressWarnings("unchecked")
@Service
public class BaseDaoImpl implements IBaseDao {

	protected Logger log = LoggerFactory.getLogger(getClass());

	protected SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public <T> T save(T domain) {
		log.debug("Save " + domain.getClass().getName());
		return (T) getCurrentSession().save(domain);
	}

	@Override
	public <T> void update(T domain) {
		log.debug("Update " + domain.getClass().getName());
		getCurrentSession().update(domain);
	}

	@Override
	public <T> T merge(T domain) {
		return (T) getCurrentSession().merge(domain);
	}

	@Override
	public <T> T load(Class<T> clazz, Serializable idValue) {
		return (T) getCurrentSession().load(clazz, idValue);
	}

	@Override
	public <T> void delete(T domain) {
		getCurrentSession().delete(domain);
	}

	@Override
	public <T> void deleteById(Class<T> clazz, Serializable id) {
		delete(load(clazz, id));
	}

	@Override
	public <T> int deleteByProperty(String propertyName, Object value, Class<T> clazz) {
		Finder finder = new Finder(" delete from " + clazz.getSimpleName());
		finder.append(" where " + propertyName + " =? ", value);
		log.debug(finder.getOrigHql());
		return executeUpdate(finder);
	}

	@Override
	public <T> T findById(Class<T> clazz, Serializable id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@Override
	public <T> List<T> findAll(Pagination page, Class<T> clazz) {
		Finder finder = new Finder(" from ");
		finder.append(clazz.getSimpleName());
		log.debug(finder.getOrigHql());
		return queryForList(finder, page);
	}

	@Override
	public <T> T findByProperty(Class<T> clazz, String propertyName, Object value) {
		Finder finder = new Finder(" FROM ");
		finder.append(clazz.getSimpleName()).append(" where " + propertyName + " =? ", value);
		log.debug(finder.getOrigHql());
		Query query = HibernateUtils.findQuery(finder, finder.getOrigHql(), getCurrentSession());
		return (T) query.uniqueResult();
	}

	@Override
	public <T> boolean isExistById(Class<T> clazz, Serializable idValue) {
		return load(clazz, idValue) != null;
	}

	@Override
	public <X> List<X> queryForList(Finder finder, Pagination page) {
		Query query = HibernateUtils.findQuery(finder, finder.getOrigHql(), getCurrentSession());
		// 不分页查询
		if (page == null) {
			return query.list();
		}
		// 分页查询
		Query countQuery = HibernateUtils.findQuery(finder, finder.getRowCountHql(), getCurrentSession());
		Long count = Long.valueOf(countQuery.uniqueResult().toString());
		if (count == null || count < 1) {
			// 没有数据,返回null
			return new ArrayList<X>();
		}
		page.setTotalCount(count.intValue());
		// query.setCacheable(true);
		return query.setFirstResult(page.getFirstResult()).setMaxResults(page.getPageSize()).list();
	}

	@Override
	public <X> X queryForObject(Finder finder) {
		return (X) HibernateUtils.findQuery(finder, finder.getOrigHql(), getCurrentSession()).uniqueResult();
	}

	@Override
	public int executeUpdate(Finder finder) {
		Query query = HibernateUtils.findQuery(finder, finder.getOrigHql(), getCurrentSession());
		return query.executeUpdate();
	}

}
