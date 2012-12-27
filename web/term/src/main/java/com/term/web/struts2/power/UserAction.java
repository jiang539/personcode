package com.term.web.struts2.power;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.term.business.dto.UserDto;
import com.term.business.service.power.IUserService;
import com.term.utils.Utilities;
import com.term.web.core.BaseCrudActionSupport;
import com.term.web.core.CrudActionSupport;

/**
 * 用户信息action
 * 
 * @author 李国江
 * @date 2009-5-2 上午10:42:10
 */
@ParentPackage("default")
@Results( { @Result(name = CrudActionSupport.RELOAD, location = "/power/user.action", type = "redirect") })
public class UserAction extends BaseCrudActionSupport<UserDto> {

	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
		this.baseService = userService;
		entity = new UserDto();
	}

	@Override
	public void beforeSave() throws Exception {
		eccoderPwd();
	}

	@Override
	public void beforeUpdate() throws Exception {
		if (entity.getPassword() != null) {
			eccoderPwd();
		}
	}

	/**
	 * 密码加密
	 */
	private void eccoderPwd() {
		String pwd = Utilities.encoderByMd5For32Bit(entity.getPassword());
		entity.setPassword(pwd);
	}

	private boolean uniqueCheck() throws Exception {
		if (userService.isExistByProperty(entity.getId(), "name", entity
				.getName())) {
			addActionMessage("用户名已经存在,请重新填写");
			return true;
		}
		return false;
	}

	@Override
	public String delete() throws Exception {
		if ("admin".equals(sid)) {
			throw new RuntimeException("管理员用户不准删除!");
		}
		return super.delete();
	}

}
