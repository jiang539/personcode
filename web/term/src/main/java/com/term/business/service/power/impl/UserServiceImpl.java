package com.term.business.service.power.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.term.business.core.BaseServiceImpl;
import com.term.business.dto.UserDto;
import com.term.business.service.power.IUserService;
import com.term.dbaccess.dao.power.IUserDao;
import com.term.dbaccess.dao.power.IUserRoleDao;
import com.xinxi11.web.entity.qx.User;

/**
 * 用户信息
 * 
 * @author 李国江
 * @date 2009-5-2 上午10:38:25
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserDto, User> implements
		IUserService {

	private IUserDao userDao;
	private IUserRoleDao userRoleDao;

	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
		this.baseHibernateDao = userDao;
	}

	@Autowired
	public void setUserRoleDao(IUserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	@Override
	public int updatePassword(String id, String oldPwd, String newPwd) {
		return userDao.updatePassword(id, oldPwd, newPwd);
	}

	@Override
	public List<UserDto> findByRoleId(String roleId) {
		List<User> listEntity = userRoleDao.findByRoleId(roleId);
		return listEntityToDto(listEntity);
	}

	@Override
	public boolean loginCheck(String username, String encoderByMd5For32Bit) {
		return userDao.loginCheck(username, encoderByMd5For32Bit);
	}

}
