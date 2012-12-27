package com.term.web.core;

import com.term.business.dto.UserDto;

/**
 * Struts2中CRUD典型Action规范类. 规定使用Preparable,ModelDriven接口,规范了一些函数的命名.
 * 
 * @param <T>
 *            CRUD所管理的对象类型
 */
@SuppressWarnings("serial")
public abstract class CrudActionSupport extends BaseActionSupport {

	/**
	 * Action函数,默认action函数，默认指向list函数.
	 */
	@Override
	public String execute() throws Exception {
		return list();
	}

	/**
	 * Action函数,显示Entity列表. return SUCCESS.
	 */
	public abstract String list() throws Exception;

	/**
	 * Action函数,新增Entity. return RELOAD.
	 */
	public abstract String save() throws Exception;

	/**
	 * Action函数,修改Entity. return RELOAD.
	 */
	public abstract String update() throws Exception;

	/**
	 * Action函数,删除Entity. return null.
	 */
	public abstract String delete() throws Exception;

	/**
	 * ajax验证用户输入信息
	 */
	public String isExist() throws Exception {
		return null;
	}

}
