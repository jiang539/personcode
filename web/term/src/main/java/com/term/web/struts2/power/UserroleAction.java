package com.term.web.struts2.power;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.term.business.dto.RoleDto;
import com.term.business.dto.UserDto;
import com.term.business.dto.UserRoleDto;
import com.term.business.service.power.IRoleService;
import com.term.business.service.power.IUserRoleService;
import com.term.business.service.power.IUserService;
import com.term.web.core.BaseCrudActionSupport;
import com.term.web.core.CrudActionSupport;

/**
 * 用户角色
 * 
 * @author 李国江
 * @date 2009-5-8 上午09:47:10
 */
@ParentPackage("default")
@Results( { @Result(name = CrudActionSupport.RELOAD, location = "/power/userrole.action", type = "redirect") })
public class UserroleAction extends BaseCrudActionSupport<UserRoleDto> {

	private IUserRoleService userRoleService;
	private IUserService userService;
	private IRoleService roleService;

	private List<UserDto> listUserDto;
	private List<RoleDto> listRoleDto;

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
		this.baseService = userRoleService;
		entity = new UserRoleDto();
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public List<UserDto> getListUserDto() {
		return listUserDto;
	}

	public List<RoleDto> getListRoleDto() {
		return listRoleDto;
	}

	@Override
	public String list() throws Exception {
		listUserDto = userService.findAll(null);
		listRoleDto = roleService.findAll(null);
		return SUCCESS;
	}

}
