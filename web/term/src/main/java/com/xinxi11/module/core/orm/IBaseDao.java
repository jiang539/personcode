package com.xinxi11.module.core.orm;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.xinxi11.module.core.entity.IEntity;
import com.xinxi11.module.core.entity.IQueryBean;

/**
 * 基本的CRUD操作<br>
 * saveOrUpdate后的对象会纳入session的管理，对象的状态会跟数据库同步，再次查询该对象会直接从session中取，<br>
 * merge后的对象不会纳入session的管理，再次查询该对象还是会从数据库中取。<br>
 * <br>
 * find* 表示查询对象T<br>
 * query* 表示查询其它对象
 * 
 * @author 李国江
 */
public interface IBaseDao<T extends IEntity<Serializable>> {
	/**
	 * 保存对象
	 * 
	 * @param domain
	 */
	Serializable save(T domain);

	/**
	 * 保存或者更新<br>
	 * select,update/insert[2条sql]<br>
	 * <b>尽量不要使用,容易出错</b>
	 * 
	 * 
	 * @param domain
	 */
	@Deprecated
	void saveOrUpdate(T domain);

	/**
	 * 更新对象
	 * 
	 * @param domain
	 */
	void update(T domain);

	/**
	 * 将传入的detached状态的对象的属性复制到持久化对象中，并返回该持久化对象 。<br>
	 * 如果该session中没有关联的持久化对象，加载一个，<br>
	 * 如果传入对象未保存，保存一个副本并作为持久对象返回，传入对象依然保持detached状态。<br>
	 * merge=select,update/insert,select[3条sql]
	 * 
	 * @param t
	 *            detached状态的,更新之前的对象
	 * @return detached状态的,更新之后的对象
	 */
	T merge(T domain);

	T load(Serializable id);

	/**
	 * 删除对象
	 * 
	 * @param domain
	 */
	void delete(T domain);

	/**
	 * 删除对象
	 * 
	 * @param domain
	 */
	void deleteById(Serializable id);

	/**
	 * 将记录的状态置为删除
	 * 
	 * @param id
	 *            记录
	 * @return 受影响的行数
	 */
	int deleteActive(Set<Serializable> ids);

	/**
	 * 按属性值删除对象
	 * 
	 * @param propertyName
	 *            列名
	 * @param value
	 *            列值
	 * @return 受影响的行数
	 */
	int deleteByProperty(String propertyName, Object value);

	/**
	 * 通过id查询对象
	 * 
	 * @param id
	 * @return
	 */
	T findById(Serializable id);

	/**
	 * 查询所有对象
	 * 
	 * @return
	 */
	List<T> findAll(Pagination page);

	/**
	 * 通过查询条件bean,查询数据
	 * 
	 * @param querybean
	 *            查询条件bean
	 * @param page
	 *            分页
	 * @return
	 */
	<Querybean extends IQueryBean> List<T> findByQueryBean(
			Querybean querybean, Pagination page);

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
	List<T> findByProperty(String propertyName, Object value, Pagination page);

	/**
	 * 通过属性,查询唯一实体
	 * 
	 * @param propertyName
	 *            属性
	 * @param value
	 *            值
	 * @return 唯一实体
	 */
	T findByProperty(String propertyName, Object value);

	/**
	 * 通过列值查询,hql查询
	 * 
	 * @param propertyName
	 *            列名
	 * @param value
	 *            列值,%value%
	 * @param page
	 *            分页
	 * @return
	 */
	List<T> findLikeProperty(String propertyName, Object value, Pagination page);

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
	boolean isExistByProperty(Serializable id, String propertyName, Object value);

	/**
	 * list查询
	 * 
	 * @param <X>
	 *            返回的类型
	 * @param finder
	 *            查询语句及相应的参数
	 * @param page
	 *            分页
	 * @return list
	 */
	<X> List<X> queryForList(Finder finder, Pagination page);

	/**
	 * 唯一object查询
	 * 
	 * @param <X>
	 *            返回对象类型
	 * @param finder
	 *            查询语句及相应的参数
	 * @return object
	 */
	<X> X queryForObject(Finder finder);

	/** 执行无返回值的hql , sql 语句 */
	int executeUpdate(Finder finder);

}
