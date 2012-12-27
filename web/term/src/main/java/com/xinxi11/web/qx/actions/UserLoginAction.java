package com.xinxi11.web.qx.actions;

import org.apache.commons.lang.StringUtils;

import com.xinxi11.module.core.web.struts2.BaseActionSupport;
import com.xinxi11.module.core.web.struts2.Struts2Utils;
import com.xinxi11.web.entity.qx.User;
import com.xinxi11.web.qx.service.IUserService;

public class UserLoginAction extends BaseActionSupport<User> {

	private static final long serialVersionUID = 639712395672118399L;
	private IUserService userService;
	private String username;
	private String password;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			addActionMessage("用户名和密码都不能为空!");
			return LOGIN;
		}
		User user = userService.findById(username, User.class);
		if (user.getPassword().equals(password)) {
			Struts2Utils.getSession().setAttribute("user", user);
			return SUCCESS;
		} else {
			addActionMessage("用户名和密码不匹配,请重新输入!");
		}
		return LOGIN;
	}
}
