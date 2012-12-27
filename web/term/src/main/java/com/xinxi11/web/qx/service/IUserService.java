package com.xinxi11.web.qx.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xinxi11.module.core.cache.LoginUserInfo;
import com.xinxi11.module.core.service.IBaseService;
import com.xinxi11.web.entity.qx.User;

/**
 * 用户管理
 */
@Transactional
public interface IUserService extends IBaseService {

	/**
	 * 修改密码
	 * 
	 * @param id
	 *            用户登陆id
	 * @param oldPwd
	 *            旧密码
	 * @param newPwd
	 *            新密码
	 * @return 1:修改成功;2:不能修改,oldPwd不对
	 */
	@Transactional
	int updatePassword(String id, String oldPwd, String newPwd);

	/**
	 * 查询符合某一角色的用户
	 * 
	 * @param roleId
	 *            角色id
	 * @return List<UserDto>
	 */
	@Transactional(readOnly = true)
	List<User> findByRoleId(String roleId);

	LoginUserInfo findLoginUserInfo(String userId);

}
