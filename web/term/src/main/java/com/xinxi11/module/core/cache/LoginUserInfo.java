package com.xinxi11.module.core.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.xinxi11.web.entity.qx.Department;
import com.xinxi11.web.entity.qx.Role;

/**
 * 登陆用户的基本信息
 * 
 * @author Guojiang Li
 * @date 2010-6-2
 */
public class LoginUserInfo implements Serializable {

	private static final long serialVersionUID = -7913276019502423644L;

	private String id;
	private String userName;
	private Boolean isAdmin = false;
	private Boolean isManager = false;
	private Boolean isEmployee = true;
	private List<Department> unitInfos = new ArrayList<Department>();
	private List<Role> roles = new ArrayList<Role>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}

	public Boolean getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public List<Department> getUnitInfos() {
		return unitInfos;
	}

	public void setUnitInfos(List<Department> unitInfos) {
		this.unitInfos = unitInfos;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
