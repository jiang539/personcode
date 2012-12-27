package com.xinxi11.web.qx.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinxi11.module.core.service.IBaseService;
import com.xinxi11.module.core.web.struts2.BaseActionSupport;
import com.xinxi11.web.entity.qx.User;
import com.xinxi11.web.qx.querybean.UserQuerybean;

public class UserAction extends BaseActionSupport<User> {

	private static final long serialVersionUID = 1660652846190427113L;

	private IBaseService baseService;

	@Autowired
	public void setBaseService(IBaseService baseService) {
		this.baseService = baseService;
		this.querybean = new UserQuerybean();
		this.dto = new User();
	}

	@Override
	public String execute() throws Exception {
		listDto = baseService.findByQueryBean(getQuerybean(), getPage());
		return LIST;
	}

	public String saveForm() {
		return UPDATE;
	}

	public String save() throws Exception {
		baseService.save(dto);
		return RELOAD;
	}

}
