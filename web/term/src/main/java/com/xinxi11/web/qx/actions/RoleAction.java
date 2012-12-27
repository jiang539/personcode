package com.xinxi11.web.qx.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinxi11.module.core.web.struts2.BaseActionSupport;
import com.xinxi11.web.entity.qx.Role;
import com.xinxi11.web.qx.service.IRoleService;

/**
 * 请在此加入你的功能说明
 * 
 * @author 李国江
 * @date 2012-9-14
 */
public class RoleAction extends BaseActionSupport<Role> {

	private static final long serialVersionUID = -5816307650913398518L;

	private IRoleService roleService;

	@Autowired
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
		this.dto = new Role();
		this.querybean = null;
	}

	@Override
	public String execute() throws Exception {
		return LIST;
	}
	
	public String ajaxRoleTree(){
		listDto=roleService.findRole
	}

}
