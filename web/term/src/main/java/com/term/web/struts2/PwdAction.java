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
@Results( {
		@Result(name = BaseActionSupport.SUCCESS, location = "/main.action", type = "redirect"),
		@Result(name = BaseActionSupport.INPUT, location = "/WEB-INF/pages/power/pwd.jsp") })
public class PwdAction extends BaseActionSupport {

	private IUserService userService;
	private String password;
	private String password21;
	private String password22;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPassword21(String password21) {
		this.password21 = password21;
	}

	public void setPassword22(String password22) {
		this.password22 = password22;
	}

	@Override
	public String input() throws Exception {
		return INPUT;
	}

	@Override
	public String execute() throws Exception {
		UserDto user = getUserDetail();
		if (user == null) {
			return LOGIN;
		}
		if (StringUtils.isBlank(password) || StringUtils.isBlank(password21)
				|| StringUtils.isBlank(password22)) {
			addActionMessage("输入信息不能为空");
			return INPUT;
		}
		if (!password21.equals(password22)) {
			addActionMessage("新密码不一致");
			return INPUT;
		}
		password = Utilities.encoderByMd5For32Bit(password);
		password21 = Utilities.encoderByMd5For32Bit(password21);
		if (!user.getPassword().equals(password)) {
			addActionMessage("密码不匹配,请重新输入密码");
			return INPUT;
		}
		userService.updatePassword(user.getId(), password, password21);
		user.setPassword(password21);
		Struts2Utils.getSession().setAttribute("user", user);
		addActionMessage("密码修改成功");
		return SUCCESS;
	}

	public String loginout() throws Exception {
		Struts2Utils.getSession().removeAttribute("user");
		return LOGIN;
	}

}
