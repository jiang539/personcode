package com.term.dbaccess.dao.power.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.term.dbaccess.core.BaseHibernateDaoImpl;
import com.term.dbaccess.dao.power.IUserRoleDao;
import com.xinxi11.web.entity.qx.User;
import com.xinxi11.web.entity.qx.UserRole;

@Service("userRoleDao")
public class UserRoleDaoImpl extends BaseHibernateDaoImpl<UserRole> implements
		IUserRoleDao {

	public UserRoleDaoImpl() {
		super(UserRole.class);
	}

	@Override
	public List<User> findByRoleId(String roleId) {
		// TODO Auto-generated method stub
		String hql="select user.* from UserRole where role.id=?";
		return null;
	}

}
