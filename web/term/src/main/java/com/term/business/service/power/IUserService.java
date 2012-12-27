package com.term.business.service.power;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.term.business.core.IBaseService;
import com.term.business.dto.UserDto;

/**
 * 用户管理
 */
@Transactional
public interface IUserService extends IBaseService<UserDto> {

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
	int updatePassword(String id, String oldPwd, String newPwd);

	/**
	 * 查询符合某一角色的用户
	 * 
	 * @param roleId
	 *            角色id
	 * @return List<UserDto>
	 */
	List<UserDto> findByRoleId(String roleId);

	boolean loginCheck(String username, String encoderByMd5For32Bit);

}
