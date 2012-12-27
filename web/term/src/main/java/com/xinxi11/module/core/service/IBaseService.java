package com.xinxi11.module.core.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xinxi11.module.core.entity.IEntity;
import com.xinxi11.module.core.entity.IQueryBean;
import com.xinxi11.module.core.orm.Pagination;

/**
 *
 */
@Transactional
public interface IBaseService {

	/**
	 * 保存对象
	 */
	@Transactional
	<T extends IEntity<?>> Serializable save(T t);

	/**
	 * 批量保存对象,主要 用于导入操作
	 */
	@Transactional
	<T extends IEntity<?>> void save(List<T> listEntity);

	/**
	 * 更新对象
	 * 
	 * @param t
	 */
	@Transactional
	<T extends IEntity<?>> boolean update(T t);

	/**
	 * 批量删除对象,从数据库彻底删除
	 * 
	 * @param ids
	 *            对象的id集合
	 * @return
	 */
	@Transactional
	<T extends IEntity<?>> boolean delete(Serializable ids[], Class<T> clazz);

	@Transactional
	<T extends IEntity<?>> boolean delete(Serializable id, Class<T> clazz);

	/**
	 * 状态删除
	 */
	@Transactional
	<T extends IEntity<?>> boolean deleteActive(Collection<Serializable> ids,
			Class<T> clazz);

	/**
	 * 状态删除
	 */
	@Transactional
	<T extends IEntity<?>> boolean deleteActive(Serializable id, Class<T> clazz);

	/**
	 * 通过id查询对象
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	<T extends IEntity<?>> T findById(Serializable id, Class<T> clazz);

	/**
	 * 通过查询条件bean,查询对象数据
	 */
	@Transactional(readOnly = true)
	<X> X findByQueryBean(IQueryBean qyerybean);

	/**
	 * 通过查询条件bean,查询列表数据
	 * 
	 * @param querybean
	 *            查询条件bean
	 * @param page
	 *            分页
	 * @return
	 */
	@Transactional(readOnly = true)
	<X> List<X> findByQueryBean(IQueryBean querybean, Pagination page);

}
