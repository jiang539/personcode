package com.term.dbaccess.core;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

/**
 * 基本的CRUD操作<br>
 * saveOrUpdate后的对象会纳入session的管理，对象的状态会跟数据库同步，再次查询该对象会直接从session中取，<br>
 * merge后的对象不会纳入session的管理，再次查询该对象还是会从数据库中取。
 * 
 */
public interface IBaseDao<T> {

	/**
	 * 保存对象
	 * 
	 * @param domain
	 */
	public Serializable save(T domain);

	/**
	 * 保存或者更新<br>
	 * select,update/insert[2条sql]
	 * 
	 * 
	 * @param domain
	 */
	public void saveOrUpdate(T domain);

	/**
	 * 更新对象
	 * 
	 * @param domain
	 */
	public void update(T domain);

	/**
	 * 将传入的detached状态的对象的属性复制到持久化对象中，并返回该持久化对象 。<br>
	 * 如果该session中没有关联的持久化对象，加载一个，<br>
	 * 如果传入对象未保存，保存一个副本并作为持久对象返回，传入对象依然保持detached状态。<br>
	 * merge=select,update/insert,select[3条sql]
	 * 
	 * 
	 * @param t
	 *            detached状态的,更新之前的对象
	 * @return detached状态的,更新之后的对象
	 */
	public T merge(T domain);

	/**
	 * 删除对象
	 * 
	 * @param domain
	 */
	public void delete(T domain);

	/**
	 * 删除对象
	 * 
	 * @param domain
	 */
	public void deleteById(Serializable id);

	/**
	 * 按属性值删除对象
	 * 
	 * @param propertyName
	 *            列名
	 * @param value
	 *            列值
	 * @return 受影响的行数
	 */
	public int deleteByProperty(String propertyName, Object value);

	/**
	 * 执行带参数的hql语句
	 * 
	 * @param hql
	 * @param values
	 * 
	 * @return 受影响的行数
	 */
	public int executeHql(final String hql, final Object[] values);

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
	public int executeHql(final String hql, final String[] names,
			final Object[] values);

	/**
	 * 执行带参数的本地 sql 语句
	 * 
	 * @param nativeSql
	 *            本地sql
	 * @param values
	 *            受影响的行数
	 * @return int
	 */
	public int executeNateiveSql(final String nativeSql, final Object[] values);

	/**
	 * 通过id查询对象
	 * 
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);

	/**
	 * 查询所有对象
	 * 
	 * @return
	 */
	public List<T> findAll(Pagination page);

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
	public List<T> findByProperty(String propertyName, Object value,
			Pagination page);

	/**
	 * 通过属性,查询唯一实体
	 * 
	 * @param propertyName
	 *            属性
	 * @param value
	 *            值
	 * @return 唯一实体
	 */
	public T findByProperty(String propertyName, Object value);

	/**
	 * 通过列值模糊匹配查询,hql查询
	 * 
	 * @param propertyName
	 *            列名
	 * @param value
	 *            列值, 根据需要自己在前后加 '%'
	 * @param page
	 *            分页
	 * @return
	 */
	public List<T> findLikeProperty(String propertyName, Object value,
			Pagination page);

	/**
	 * 带参数的分页查询
	 * 
	 * @param select
	 *            sql
	 * @param values
	 * @param page
	 * @return
	 */
	public List<T> findForList(String hql, Object[] values);

	/**
	 * 带参数分页查询
	 * 
	 * @param hqlCount
	 *            count语句
	 * @param hqlSelect
	 *            hql
	 * @param values
	 * @param page
	 * @return
	 */
	public List<T> findForList(final String hqlCount, final String hqlSelect,
			final Object[] values, final Pagination page);

	/**
	 * 查找唯一实体
	 * 
	 * @param hql
	 *            hql
	 * @param values
	 *            参数
	 * @return 唯一实体
	 */
	public Object findForUnique(final String hql, final Object[] values);

	/**
	 * 通过属性值,判断是否存在该值的对象.<br>
	 * value可以为空
	 * 
	 * @param propertyName
	 *            属性
	 * @param value
	 *            属性值,可以为空
	 * @return
	 */
	public boolean isExistByProperty(String propertyName, Object value);

	/**
	 * 通过属性值,判断是否存在该值的对象.<br>
	 * value可以为空
	 * 
	 * @param id
	 * @param propertyName
	 *            属性
	 * @param value
	 *            属性值,可以为空
	 * @return
	 */
	public boolean isExistByProperty(Serializable id, String propertyName,
			Object value);

	/**
	 * 关联条件查询
	 * 
	 * @param dc
	 *            关联条件
	 * @param page
	 * @return
	 */
	public List queryForList(DetachedCriteria dc, Pagination page);

	/**
	 * 本地sql 查询
	 * 
	 * @param selectCount
	 *            统计分页
	 * @param selectNativeSQl
	 *            native sql,原生sql
	 * @param values
	 *            参数
	 * @param page
	 * @return
	 */
	public List queryByNativeSql(final String selectCount,
			final String selectNativeSQl, final Object[] values,
			final Pagination page);

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
	public List queryForList(final String hql, final Object[] values);

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
	public List queryForList(final String hql, final String[] names,
			final Object[] values);

	/**
	 * 获取当前的 SessionFactory
	 * 
	 * @return
	 */
	public SessionFactory getSessionFactory();
}