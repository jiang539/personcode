package com.term.dbaccess.dao.power.impl;

import org.springframework.stereotype.Service;

import com.term.dbaccess.core.BaseHibernateDaoImpl;
import com.term.dbaccess.dao.power.IRoleDao;
import com.xinxi11.web.entity.qx.Role;

/**
 * 角色管理
 * 
 * @author 李国江
 * @date 2009-5-2 下午02:18:06
 */
@Service("roleDao")
public class RoleDaoImpl extends BaseHibernateDaoImpl<Role> implements IRoleDao {

	public RoleDaoImpl() {
		super(Role.class);
	}

}
