package com.xinxi11.web.qx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinxi11.module.core.cache.LoginUserInfo;
import com.xinxi11.module.core.orm.hibernate.IHibernateDao;
import com.xinxi11.module.core.service.impl.BaseServiceImpl;
import com.xinxi11.web.entity.qx.User;
import com.xinxi11.web.qx.service.IUserService;

/**
 * 用户信息
 * 
 * @author 李国江
 * @date 2009-5-2 上午10:38:25
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements IUserService {

	@Autowired
	private IHibernateDao hibernateDao;

	@Override
	public int updatePassword(String id, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginUserInfo findLoginUserInfo(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
