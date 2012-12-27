package com.xinxi11.module.core.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao {

	/**
	 * 保存对象
	 * 
	 * @param domain
	 */
	<T> T save(T domain);

	/**
	 * 更新对象
	 * 
	 * @param domain
	 */
	<T> void update(T domain);

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
	<T> T merge(T domain);

	<T> T load(Class<T> clazz, Serializable idValue);

	/**
	 * 删除对象
	 * 
	 * @param domain
	 */
	<T> void delete(T domain);

	/**
	 * 删除对象
	 * 
	 * @param clazz
	 */
	<T> void deleteById(Class<T> clazz, Serializable id);

	/**
	 * 按属性值删除对象
	 * 
	 * @param propertyName
	 *            列名
	 * @param value
	 *            列值
	 * @return 受影响的行数
	 */
	<T> int deleteByProperty(String propertyName, Object value, Class<T> clazz);

	/**
	 * 通过id查询对象
	 * 
	 * @param id
	 * @return
	 */
	<T> T findById(Class<T> clazz, Serializable id);

	/**
	 * 查询所有对象
	 * 
	 * @return
	 */
	<T> List<T> findAll(Pagination page, Class<T> clazz);

	/**
	 * 通过属性,查询唯一实体
	 * 
	 * @param propertyName
	 *            属性
	 * @param value
	 *            值
	 * @return 唯一实体
	 */
	<T> T findByProperty(Class<T> clazz, String propertyName, Object value);

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
	<T> boolean isExistById(Class<T> clazz, Serializable idValue);

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
