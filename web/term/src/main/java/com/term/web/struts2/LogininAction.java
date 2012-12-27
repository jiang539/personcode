package com.term.web.struts2;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.term.business.dto.UserDto;
import com.term.business.service.power.IUserService;
import com.term.utils.Utilities;
import com.term.web.core.BaseActionSupport;
import com.term.web.core.Struts2Utils;

/**
 * 用户登陆控制
 * 
 * @author 李国江
 * @date 2009-5-11 上午09:44:01
 */
@ParentPackage("default")
@Results( { @Result(name = BaseActionSupport.SUCCESS, location = "/main.action", type = "redirect",params={"",""}) })
public class LogininAction extends BaseActionSupport {

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
	public String input() throws Exception {
		return LOGIN;
	}

	@Override
	public String execute() throws Exception {
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			addActionMessage("用户名和密码都不能为空!");
			return LOGIN;
		}
		UserDto user = userService.findById(username);
		if (user.getPassword().equals(Utilities.encoderByMd5For32Bit(password))) {
			Struts2Utils.getSession().setAttribute("user", user);
			return SUCCESS;
		} else {
			addActionMessage("用户名和密码不匹配,请重新输入!");
		}
		return LOGIN;
	}

}
