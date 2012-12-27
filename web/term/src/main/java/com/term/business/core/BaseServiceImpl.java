package com.term.business.core;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.term.dbaccess.core.IBaseDao;
import com.term.dbaccess.core.Pagination;
import com.term.utils.BeanCopyUtil;

/**
 * service 通用操作
 */
@SuppressWarnings("unchecked")
public abstract class BaseServiceImpl<Dto, Entity> implements IBaseService<Dto> {

	private Log log = LogFactory.getLog(getClass());
	protected IBaseDao<Entity> baseHibernateDao;

	@Override
	public boolean delete(Integer id) {
		baseHibernateDao.deleteById(id);
		return true;
	}

	@Override
	public boolean delete(String ids) {
		String[] _ids = StringUtils.split(ids, ",");
		for (Serializable id : _ids) {
			baseHibernateDao.deleteById(id);
		}
		return true;
	}

	@Override
	public List<Dto> findAll(Pagination page) {
		List<Entity> listEntity = baseHibernateDao.findAll(page);
		return listEntityToDto(listEntity);
	}

	@Override
	public Dto findById(Serializable id) {
		Entity entity = baseHibernateDao.findById(id);
		return entityToDto(entity);
	}

	@Override
	public boolean isExistByProperty(Serializable id, String propertyName,
			Object value) {
		return baseHibernateDao.isExistByProperty(id, propertyName, value);
	}

	@Override
	public boolean save(Dto domain) {
		baseHibernateDao.save(dtoToEntity(domain));
		return true;
	}

	@Override
	public boolean saveOrUpdate(Dto domain) {
		baseHibernateDao.saveOrUpdate(dtoToEntity(domain));
		return true;
	}

	@Override
	public boolean update(Dto domain) {
		baseHibernateDao.update(dtoToEntity(domain));
		return true;
	}

	/**
	 * dto to entity,没有对象之间的转换<br>
	 * 如果有特殊需求,请重写本方法
	 * 
	 * @param dto
	 * @return
	 */

	protected Entity dtoToEntity(Dto dto) {
		Entity entity = (Entity) getNewInstanse(1);
		BeanCopyUtil.copyProperties(entity, dto);
		return entity;
	}

	/**
	 * entity to dto,没有对象之间的转换<br>
	 * 如果有特殊需求,请重写本方法
	 * 
	 * @param entity
	 * @return
	 */
	protected Dto entityToDto(Entity entity) {
		Dto dto = (Dto) getNewInstanse(0);
		BeanCopyUtil.copyProperties(dto, entity);
		return dto;
	}

	/**
	 * listEntity to listDto
	 * 
	 * @param listEntity
	 * @return
	 */
	protected List<Dto> listEntityToDto(List<Entity> listEntity) {
		List<Dto> listDto = new ArrayList<Dto>();
		if (listEntity == null) {
			return listDto;
		}
		for (Entity entity : listEntity) {
			listDto.add(entityToDto(entity));
		}
		return listDto;
	}

	/**
	 * @param <K>
	 * @param index
	 *            构造的顺序. 0:Dto ; 1:Entity
	 * @return
	 */
	private Object getNewInstanse(int index) {
		try {
			ParameterizedType superType = (ParameterizedType) getClass()
					.getGenericSuperclass();
			Class clazz = (Class) superType.getActualTypeArguments()[index];
			return (Object) Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException e) {
			log.warn(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			log.warn(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			log.warn(e.getMessage(), e);
		}
		return null;
	}

}
