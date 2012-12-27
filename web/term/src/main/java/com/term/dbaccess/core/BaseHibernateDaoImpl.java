package com.term.dbaccess.core;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * hibernate 实现的基本的CRUD操作
 */
@SuppressWarnings("unchecked")
@Service("baseHibernateDao")
public class BaseHibernateDaoImpl<T> implements IBaseDao<T> {
	protected Log log = LogFactory.getLog(getClass());

	/**
	 * 操作的对象
	 */
	private final Class<T> clazz;

	protected SessionFactory sessionFactory;
	private String tableIdName = "id";// 表对象的主键的名字,默认为"id"

	public String setTableIdName() {
		return tableIdName;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 构造方法
	 * 
	 * @param clazz
	 *            本次操作的对象
	 */
	public BaseHibernateDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * 构造方法
	 * 
	 * @param hibernateSessionFactory
	 * @param clazz
	 */
	public BaseHibernateDaoImpl(SessionFactory sessionFactory, Class<T> clazz) {
		this.sessionFactory = sessionFactory;
		this.clazz = clazz;
	}

	@Override
	public Serializable save(T t) {
		log.debug("save " + getTableName());
		return getCurrentSession().save(t);
	}

	@Override
	public void saveOrUpdate(T domain) {
		log.debug("saveOrUpdate " + getTableName());
		getCurrentSession().saveOrUpdate(domain);
	}

	@Override
	public void update(T t) {
		log.debug("update " + getTableName());
		getCurrentSession().update(t);
	}

	@Override
	public T merge(T t) {
		log.debug("update " + getTableName());
		return (T) getCurrentSession().merge(t);
	}

	@Override
	public void delete(T t) {
		log.debug("delete " + getTableName());
		getCurrentSession().delete(t);
	}

	@Override
	public void deleteById(Serializable id) {
		delete(findById(id));
	}

	@Override
	public int deleteByProperty(String propertyName, Object value) {
		String hql = " delete from " + getTableName() + " where "
				+ propertyName + "=?";
		Object[] values = new Object[] { value };
		return executeHql(hql, values);
	}

	@Override
	public List<T> findAll(Pagination page) {
		log.debug("findAll " + getTableName());
		String queryString = " from " + getTableName();
		String selectCount = "select count(*) from " + getTableName();
		return findForList(selectCount, queryString, null, page);
	}

	@Override
	public T findById(Serializable id) {
		log.debug(" findById " + getTableName() + " id");
		return (T) getCurrentSession().get(clazz, id);
	}

	/**
	 * 通过属性,查询唯一实体
	 * 
	 * @param propertyName
	 *            属性
	 * @param value
	 *            值
	 * @return 唯一实体
	 */
	@Override
	public T findByProperty(String propertyName, Object value) {
		String hql = " from " + getTableName() + " as model where model."
				+ propertyName + "= ? ";
		Object[] values = new Object[] { value };
		return (T) findForUnique(hql, values);
	}

	/**
	 * 通过列值精确查询
	 * 
	 * @param propertyName
	 *            列名
	 * @param value
	 *            列值
	 * @param page
	 *            分页
	 * @return
	 */
	@Override
	public List<T> findByProperty(String propertyName, Object value,
			Pagination page) {
		String querySql = " from " + getTableName() + " as model where model."
				+ propertyName + "= ? ";
		String queryCount = "select count(*)  " + querySql;
		Object[] values = new Object[] { value };
		return findForList(queryCount, querySql, values, page);
	}

	@Override
	public List<T> findLikeProperty(String propertyName, Object value,
			Pagination page) {
		String querySql = " from " + getTableName() + " as model where model."
				+ propertyName + " like ? ";
		String queryCount = "select count(*) " + querySql;
		Object[] values = new Object[] { value };
		return findForList(queryCount, querySql, values, page);
	}

	@Override
	public boolean isExistByProperty(String propertyName, Object value) {
		String hql = "select count(*) from " + getTableName() + " where "
				+ propertyName;
		if (value == null) {
			hql += " is null";
		} else {
			hql += " =?";
		}
		Object[] values = new Object[] { value };
		Long count = (Long) findForUnique(hql, values);
		return (count != null && count > 0) ? true : false;
	}

	@Override
	public boolean isExistByProperty(Serializable id, String propertyName,
			Object value) {
		String hql = " select " + tableIdName + " from " + getTableName()
				+ " where " + propertyName + "=?";
		Object[] values = new Object[] { value };
		List<Serializable> list = queryForList(hql, values);
		if (list == null || list.size() < 1) {
			return false;
		}
		if (id == null) {// 保存时验证数据
			return false;
		}
		// 更新时验证数据
		if (id.equals(list.get(0))) {
			// 更新时数据没有改变
			return false;
		}
		return true;
	}

	/**
	 * 根据条件获取符合条件的数据的行数
	 * 
	 * @param selectCount
	 *            count hql
	 * @param values
	 *            sql 参数
	 * @return int 行数
	 */
	public int findCount(String selectCount, Object[] values) {
		Long count = (Long) findForUnique(selectCount, values);
		if (count == null) {
			return 0;
		}
		return count.intValue();
	}

	/**
	 * 执行带参数的hql语句
	 * 
	 * @param updateHql
	 *            hql
	 * @param values
	 *            参数
	 * @return int 受影响的行数
	 */
	@Override
	public int executeHql(final String updateHql, final Object[] values) {
		Query query = getCurrentSession().createQuery(updateHql);
		return _executeUpdate(query, values, null);
	}

	/**
	 * 执行带参数的hql语句
	 * 
	 * @param updateHql
	 *            hql
	 * @param names
	 *            命名符.如果为空,按占位符处理
	 * @param values
	 *            参数值
	 * 
	 * @return 受影响的行数
	 */
	@Override
	public int executeHql(final String updateHql, final String[] names,
			final Object[] values) {
		Query query = getCurrentSession().createQuery(updateHql);
		return _executeUpdate(query, values, names);
	}

	/**
	 * 执行带参数的本地 sql 语句
	 * 
	 * @param nativeSql
	 *            本地sql
	 * @param values
	 *            受影响的行数
	 * @return int
	 */
	@Override
	public int executeNateiveSql(final String nativeSql, final Object[] values) {
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(nativeSql);
		return _executeUpdate(sqlQuery, values, null);
	}

	/**
	 * 带参数分页查询
	 * 
	 * @param hqlCount
	 * @param hqlSelect
	 *            hql
	 * @param values
	 * @param page
	 * @return
	 */
	@Override
	public List<T> findForList(final String hqlCount, final String hqlSelect,
			final Object[] values, final Pagination page) {
		// 分页总行数信息
		if (hqlCount != null && page != null) {
			Query conuntQuery = getCurrentSession().createQuery(hqlCount);
			Long count = (Long) _uniqueResult(conuntQuery, values, null);
			page.setTotalCount(count.intValue());
		}
		// 查询数据信息
		Query query = getCurrentSession().createQuery(hqlSelect);
		return _list(query, values, null, page);
	}

	/**
	 * 带参数的分页查询,分页信息另外查找<br>
	 * 没有执行分页查询
	 * 
	 * @param hql
	 *            sql
	 * @param values
	 * @param page
	 * @return
	 */
	@Override
	public List<T> findForList(final String hql, final Object[] values) {
		return findForList(null, hql, values, null);
	}

	/**
	 * 本地sql 查询
	 * 
	 * @param selectCount
	 *            统计分页
	 * @param selectNativeSQl
	 *            native sql,原生sql
	 * @param values
	 *            参数
	 * @param clazzs
	 *            实体对象
	 * @param page
	 * @return
	 */
	@Override
	public List queryByNativeSql(final String selectCount,
			final String selectNativeSQl, final Object[] values,
			final Pagination page) {
		// 分页总行数信息
		if (selectCount != null && page != null) {
			// 查询有多少行数据
			SQLQuery CountQuery = getCurrentSession().createSQLQuery(
					selectCount);
			Long count = (Long) _uniqueResult(CountQuery, values, null);
			page.setTotalCount(count.intValue());
		}
		// 查询数据信息
		Query query = getCurrentSession().createQuery(selectNativeSQl);
		return _list(query, values, null, page);
	}

	/**
	 * 带参数的 hql 查询<br>
	 * 按用户的需求返回相应的结果集
	 * 
	 * @param select
	 *            hql
	 * @param values
	 *            参数
	 * @return
	 */
	@Override
	public List queryForList(final String hql, final Object[] values) {
		return queryForList(hql, null, values);
	}

	/**
	 * 命名参数 查询
	 * 
	 * @param hql
	 *            hql
	 * @param names
	 *            命名符,如果为空,按占位符处理
	 * @param values
	 *            参数值
	 * @return list
	 */
	@Override
	public List queryForList(final String hql, final String[] names,
			final Object[] values) {
		Query query = getCurrentSession().createQuery(hql);
		return _list(query, values, names, null);
	}

	/**
	 * 关联条件查询
	 * 
	 * @param dc
	 *            关联条件
	 * @param page
	 * @return List
	 * 
	 */
	@Override
	public List queryForList(final DetachedCriteria dc, final Pagination page) {
		Criteria c = dc.getExecutableCriteria(getCurrentSession());
		if (page == null) {
			return c.list();
		}
		return PaginationCriteria.query(c, page);
	}

	/**
	 * 查找唯一实体 通过本地 sql 查询
	 * 
	 * @param nativeSQl
	 *            native sql,原生sql
	 * @param values
	 *            参数
	 * @return Object
	 */
	public Object findByNativeSqlForUnique(final String nativeSQl,
			final Object[] values) {
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(nativeSQl);
		if (values != null) {
			for (int i = 0; i < values.length; i++)
				sqlQuery.setParameter(i, values[i]);
		}
		return sqlQuery.uniqueResult();
	}

	/**
	 * 查找唯一实体
	 * 
	 * @param hql
	 *            hql
	 * @param values
	 *            参数
	 * @return 唯一实体
	 */
	@Override
	public Object findForUnique(final String hql, final Object[] values) {
		Query query = getCurrentSession().createQuery(hql);
		return _uniqueResult(query, values, null);
	}

	/**
	 * 查找唯一实体
	 * 
	 * @param dc
	 *            DetachedCriteria
	 * @return 唯一实体
	 */
	public Object findForUnique(final DetachedCriteria dc) {
		return dc.getExecutableCriteria(getCurrentSession()).uniqueResult();
	}

	/**
	 * 获取当前操作表的表名,默认为类名
	 * 
	 * @return 表名,默认为类名
	 */
	public String getTableName() {
		return clazz.getSimpleName();
	}

	/**
	 * 统一给query的参数设置参数值<br>
	 * 如果命名符为空,则按点位符来处理
	 * 
	 * @param query
	 *            query
	 * @param values
	 *            参数值
	 * @param names
	 *            命名符,如果为空,按占位符处理
	 * @return
	 */
	private Query setQueryParameter(Query query, Object[] values, String[] names) {
		if (values != null) {
			if (names == null) {
				// 占位符设置参数
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
			} else {
				// 命名参数设置
				for (int i = 0; i < values.length; i++) {
					if (values[i] instanceof Collection) {
						query.setParameterList(names[i],//
								(Collection) values[i]);
					} else {
						query.setParameter(names[i], values[i]);
					}
				}
			}
		}
		return query;
	}

	/**
	 * 查找唯一实体
	 * 
	 * @param query
	 *            query
	 * @param values
	 *            参数值
	 * @param names
	 *            命名符,如果为空,按占位符处理
	 * @return Object
	 */
	private Object _uniqueResult(Query query, Object[] values, String[] names) {
		return setQueryParameter(query, values, names).uniqueResult();
	}

	/**
	 * 查找列表对象
	 * 
	 * @param query
	 *            query
	 * @param values
	 *            参数值
	 * @param names
	 *            命名符,如果为空,按占位符处理
	 * @param page
	 * @return List
	 */
	private List _list(Query query, Object[] values, String[] names,
			Pagination page) {
		query = setQueryParameter(query, values, names);
		if (page == null) {
			return query.list();
		}
		return query.setFirstResult(page.getFirstResult()).setMaxResults(
				page.getPageSize()).list();
	}

	/**
	 * 查找 Iterator 对象
	 * 
	 * @param query
	 *            query
	 * @param values
	 *            参数值
	 * @param names
	 *            命名符,如果为空,按占位符处理
	 * @param page
	 * @return Iterator
	 */
	@SuppressWarnings("unused")
	private Iterator _iterate(Query query, Object[] values, String[] names,
			Pagination page) {
		query = setQueryParameter(query, values, names);
		if (page == null) {
			return query.iterate();
		}
		return query.setFirstResult(page.getFirstResult()).setMaxResults(
				page.getPageSize()).iterate();
	}

	/**
	 * 执行无返回值sql
	 * 
	 * @param query
	 *            query
	 * @param values
	 *            参数值
	 * @param names
	 *            命名符,如果为空,按占位符处理
	 * @return int,受影响的行数
	 */
	private int _executeUpdate(Query query, Object[] values, String[] names) {
		return new Integer(setQueryParameter(query, values, names)
				.executeUpdate());
	}

}