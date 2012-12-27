package com.xinxi11.module.core.orm.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.xinxi11.module.core.entity.IEntity;
import com.xinxi11.module.core.orm.Finder;
import com.xinxi11.module.core.orm.Pagination;

/**
 * 基础的Dao 实现,所有的Dao只需要继承这个Dao
 * 
 */
@Service("hibernateDao")
public final class HibernateDaoImpl implements IHibernateDao {

	protected Logger log = LoggerFactory.getLogger(getClass());

	protected SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateDaoImpl() {
	}

	/**
	 * 获得当前 读的 当前session
	 * 
	 * @return
	 */
	public Session getReadCurrentSession() {
		return getCurrentSession();
	}

	/**
	 * 打开新的session
	 * 
	 * @return
	 */
	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 获得当前 读的 当前session
	 * 
	 * @return
	 */
	public Session getWriteCurrentSession() {
		return getCurrentSession();
	}

	@Override
	public <T extends IEntity<?>> void delete(T domain) {
		getWriteCurrentSession().delete(domain);
	}

	@Override
	public <T extends IEntity<?>> void deleteById(Serializable id, Class<T> clazz) {
		delete(load(id, clazz));
	}

	@Override
	public <T extends IEntity<?>> int deleteByProperty(String propertyName, Object value, Class<T> clazz) {
		Finder finder = HibernateUtils.deleteByProperty(propertyName, value, clazz);
		return executeUpdate(finder);
	}

	@Override
	public int executeUpdate(Finder finder) {
		Query query = HibernateUtils.findQuery(finder, finder.getOrigHql(), getWriteCurrentSession());
		return query.executeUpdate();
	}

	@Override
	public <T extends IEntity<?>> List<T> findAll(Pagination page, Class<T> clazz) {
		Finder finder = HibernateUtils.findAll(clazz);
		return queryForList(finder, page);
	}

	@Override
	public <T extends IEntity<?>> T findById(Serializable id, Class<T> clazz) {
		return findByProperty(IEntity.TABLE_PRIMARKEY_NAME, id, clazz);
	}

	@Override
	public <T extends IEntity<?>> T findByProperty(String propertyName, Object value, Class<T> clazz) {
		Finder finder = HibernateUtils.findByProperty(propertyName, value, clazz);
		Query query = HibernateUtils.findQuery(finder, finder.getOrigHql(), getReadCurrentSession());
		return (T) query.uniqueResult();
	}

	@Override
	public <T extends IEntity<?>> List<T> findLikeProperty(String propertyName, Object value, Pagination page,
			Class<T> clazz) {
		Finder finder = HibernateUtils.findLikeProperty(propertyName, value, clazz);
		return queryForList(finder, page);
	}

	@Override
	public <T extends IEntity<?>> boolean isExistByProperty(Serializable id, String propertyName, Object value,
			Class<T> clazz) {
		Finder finder = HibernateUtils.findByProperty(propertyName, value, clazz);
		List<Serializable> list = queryForList(finder, null);
		if (list == null || list.size() < 1) {
			// 不存在对应的值,该值可以使用
			return true;
		}
		if (IEntity.TABLE_PRIMARKEY_NAME.equals(propertyName)) {// 主键不能修改
			return false;
		}
		// update时验证数据
		if (StringUtils.isNotBlank((String) id) && id.equals(list.get(0))) {
			// 更新时数据没有改变,用户将数据更改为旧值
			return true;
		}
		return false;
	}

	@Override
	public <T extends IEntity<?>> T load(Serializable id, Class<T> clazz) {
		return (T) getReadCurrentSession().load(clazz, id);
	}

	@Override
	public <T extends IEntity<?>> T merge(T domain) {
		return (T) getWriteCurrentSession().merge(domain);
	}

	@Override
	public <X> List<X> queryForList(Finder finder, Pagination page) {
		Query query = HibernateUtils.findQuery(finder, finder.getOrigHql(), getReadCurrentSession());
		// 不分页查询
		if (page == null) {
			return query.list();
		}
		// 分页查询
		Query countQuery = HibernateUtils.findQuery(finder, finder.getRowCountHql(), getReadCurrentSession());
		Long count = Long.valueOf(countQuery.uniqueResult().toString());
		if (count == null || count < 1) {
			// 没有数据,返回null
			return Lists.newArrayList();
		}
		page.setTotalCount(count.intValue());
		// query.setCacheable(true);
		return query.setFirstResult(page.getFirstResult()).setMaxResults(page.getPageSize()).list();
	}

	@Override
	public <X> X queryForObject(Finder finder) {
		return (X) HibernateUtils.findQuery(finder, finder.getOrigHql(), getReadCurrentSession()).uniqueResult();
	}

	@Override
	public <T extends IEntity<?>> Serializable save(T domain) {
		return getWriteCurrentSession().save(domain);
	}

	@Override
	public <T extends IEntity<?>> void update(T domain) {
		getWriteCurrentSession().update(domain);
	}

}
