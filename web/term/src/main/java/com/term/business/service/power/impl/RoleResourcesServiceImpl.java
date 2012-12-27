package com.term.business.service.power.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.term.business.core.BaseServiceImpl;
import com.term.business.dto.RoleResourcesDto;
import com.term.business.service.power.IRoleResourcesService;
import com.term.dbaccess.dao.power.IRoleResourcesDao;
import com.xinxi11.web.entity.qx.RoleResources;

@Service("roleResourcesService")
public class RoleResourcesServiceImpl extends
		BaseServiceImpl<RoleResourcesDto, RoleResources> implements
		IRoleResourcesService {
	private IRoleResourcesDao roleResourcesDao;

	@Autowired
	public void setRoleResourcesDao(IRoleResourcesDao roleResourcesDao) {
		this.roleResourcesDao = roleResourcesDao;
		this.baseHibernateDao = roleResourcesDao;
	}

}
