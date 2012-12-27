package com.term.business.service.power.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.term.business.core.BaseServiceImpl;
import com.term.business.dto.ResourcesDto;
import com.term.business.service.power.IResourcesService;
import com.term.dbaccess.dao.power.IResourcesDao;
import com.xinxi11.web.entity.qx.Resources;

@Service("resourcesService")
public class ResourcesServiceImpl extends
		BaseServiceImpl<ResourcesDto, Resources> implements IResourcesService {

	private IResourcesDao resourcesDao;

	@Autowired
	public void setResourcesDao(IResourcesDao resourcesDao) {
		this.resourcesDao = resourcesDao;
		this.baseHibernateDao = resourcesDao;
	}

	@Override
	public String findByResourcesIdForString(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourcesDto> findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
