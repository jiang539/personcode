package com.term.dbaccess.dao.power;

import java.util.List;

import com.term.dbaccess.core.IBaseDao;
import com.xinxi11.web.entity.qx.User;
import com.xinxi11.web.entity.qx.UserRole;

/**
 * 用户角色管理
 */
public interface IUserRoleDao extends IBaseDao<UserRole> {

	List<User> findByRoleId(String roleId);

}
