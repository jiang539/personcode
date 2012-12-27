package com.term.dbaccess.dao.power;

import com.term.dbaccess.core.IBaseDao;
import com.xinxi11.web.entity.qx.User;

/**
 * 用户管理
 */
public interface IUserDao extends IBaseDao<User> {

	/**
	 * 修改密码
	 * 
	 * @param id
	 *            用户登陆id
	 * @param oldPwd
	 *            旧密码
	 * @param newPwd
	 *            新密码
	 */
	int updatePassword(String id, String oldPwd, String newPwd);

	boolean loginCheck(String username, String encoderByMd5For32Bit);

}
