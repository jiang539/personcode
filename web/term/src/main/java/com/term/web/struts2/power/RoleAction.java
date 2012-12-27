package com.term.web.struts2.power;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.term.business.dto.RoleDto;
import com.term.business.service.power.IRoleService;
import com.term.web.core.BaseCrudActionSupport;
import com.term.web.core.CrudActionSupport;

/**
 * 角色action
 * 
 * @author 李国江
 * @date 2009-5-2 下午02:22:09
 */
@ParentPackage("default")
@Results( { @Result(name = CrudActionSupport.RELOAD, location = "/power/role.action", type = "redirect") })
public class RoleAction extends BaseCrudActionSupport<RoleDto> {

	private IRoleService roleService;

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
		this.baseService = roleService;
		entity = new RoleDto();
	}

}
