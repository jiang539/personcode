package com.term.web.struts2;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.term.web.core.BaseActionSupport;

/**
 * 菜单条
 * 
 * @author 李国江
 * @date 2009-6-11
 */
@ParentPackage("default")
@Results( { @Result(name = BaseActionSupport.SUCCESS, location = "/WEB-INF/pages/main.jsp") })
public class MainAction extends BaseActionSupport {

	@Override
	public String execute() throws Exception {
		if (getUserDetail() == null) {
			return LOGIN;
		}
		return SUCCESS;
	}

}
