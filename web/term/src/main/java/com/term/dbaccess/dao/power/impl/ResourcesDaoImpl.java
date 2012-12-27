package com.term.dbaccess.dao.power.impl;

import org.springframework.stereotype.Service;

import com.term.dbaccess.core.BaseHibernateDaoImpl;
import com.term.dbaccess.dao.power.IResourcesDao;
import com.xinxi11.web.entity.qx.Resources;

@Service("resourcesDao")
public class ResourcesDaoImpl extends BaseHibernateDaoImpl<Resources> implements
		IResourcesDao {

	public ResourcesDaoImpl() {
		super(Resources.class);
	}

}
