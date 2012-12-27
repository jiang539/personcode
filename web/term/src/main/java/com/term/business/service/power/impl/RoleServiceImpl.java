package com.term.business.service.power.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.term.business.core.BaseServiceImpl;
import com.term.business.dto.RoleDto;
import com.term.business.service.power.IRoleService;
import com.term.dbaccess.dao.power.IRoleDao;
import com.xinxi11.web.entity.qx.Role;

/**
 * 角色管理
 * 
 * @author 李国江
 * @date 2009-5-2 下午02:19:25
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<RoleDto, Role> implements
		IRoleService {

	private IRoleDao roleDao;

	@Autowired
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
		this.baseHibernateDao = roleDao;
	}

	@Override
	public List<RoleDto> findByUserIdForList(String userId) {
		// TODO 角色查询
		return null;
	}

}
