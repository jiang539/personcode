package com.xinxi11.web.qx.actions;

import com.xinxi11.module.core.web.struts2.BaseActionSupport;
import com.xinxi11.web.entity.qx.Resources;

public class MainAction extends BaseActionSupport<Resources> {

	private static final long serialVersionUID = 7058622226231796364L;

	@Override
	public String execute() throws Exception {
		log.error("到这里了!");

		return SUCCESS;
	}

}
