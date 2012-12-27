package com.xinxi11.module.core.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinxi11.module.core.dao.Finder;
import com.xinxi11.module.core.dao.IBaseDao;
import com.xinxi11.module.core.dao.Pagination;

@Transactional(readOnly = true)
@Service
public class BaseServiceImpl implements IBaseService {

	protected Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 抽象的基础dao
	 */
	protected IBaseDao baseDao;

	@Autowired
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public <T> T save(T domain) {
		return baseDao.save(domain);
	}

	@Override
	public <T> void update(T domain) {
		baseDao.update(domain);
	}

	@Override
	public <T> T merge(T domain) {
		return baseDao.merge(domain);
	}

	@Override
	public <T> T load(Class<T> clazz, Serializable idValue) {
		return baseDao.load(clazz, idValue);
	}

	@Override
	public <T> void delete(T domain) {
		baseDao.delete(domain);
	}

	@Override
	public <T> void deleteById(Class<T> clazz, Serializable id) {
		baseDao.deleteById(clazz, id);
	}

	@Override
	public <T> int deleteByProperty(String propertyName, Object value, Class<T> clazz) {
		return baseDao.deleteByProperty(propertyName, value, clazz);
	}

	@Override
	public <T> T findById(Class<T> clazz, Serializable id) {
		return baseDao.findById(clazz, id);
	}

	@Override
	public <T> List<T> findAll(Pagination page, Class<T> clazz) {
		return baseDao.findAll(page, clazz);
	}

	@Override
	public <T> T findByProperty(Class<T> clazz, String propertyName, Object value) {
		return baseDao.findByProperty(clazz, propertyName, value);
	}

	@Override
	public <T> boolean isExistById(Class<T> clazz, Serializable idValue) {
		return baseDao.isExistById(clazz, idValue);
	}

	@Override
	public <X> List<X> queryForList(Finder finder, Pagination page) {
		return baseDao.queryForList(finder, page);
	}

	@Override
	public <X> X queryForObject(Finder finder) {
		return baseDao.queryForObject(finder);
	}

	@Override
	public int executeUpdate(Finder finder) {
		return baseDao.executeUpdate(finder);
	}

}
