package com.term.dbaccess.dao.power.impl;

import org.springframework.stereotype.Service;

import com.term.dbaccess.core.BaseHibernateDaoImpl;
import com.term.dbaccess.dao.power.IRoleResourcesDao;
import com.xinxi11.web.entity.qx.RoleResources;

@Service("roleResourcesDao")
public class RoleResourcesDaoImpl extends BaseHibernateDaoImpl<RoleResources>
		implements IRoleResourcesDao {

	public RoleResourcesDaoImpl() {
		super(RoleResources.class);
	}

}
