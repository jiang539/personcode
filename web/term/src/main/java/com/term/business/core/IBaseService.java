package com.term.business.core;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.term.dbaccess.core.Pagination;

@Transactional
public interface IBaseService<Dto> {
	/**
	 * 保存对象
	 * 
	 * @param domain
	 */
	boolean save(Dto domain);

	/**
	 * 保存或者更新
	 * 
	 * @param domain
	 */
	boolean saveOrUpdate(Dto domain);

	/**
	 * 更新对象
	 * 
	 * @param domain
	 */
	boolean update(Dto domain);

	/**
	 * 删除对象
	 * 
	 * @param id
	 *            对象的主键
	 */
	boolean delete(Integer id);

	/**
	 * 批量删除对象
	 * 
	 * @param ids
	 *            对象的id集合,以','为分割
	 * @return
	 */
	boolean delete(String ids);

	/**
	 * 通过id查询对象
	 * 
	 * @param id
	 * @return
	 */
	Dto findById(Serializable id);

	/**
	 * 查询所有对象
	 * 
	 * @return
	 */
	List<Dto> findAll(Pagination page);

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
}
