package com.xinxi11.web.qx.querybean;

import com.xinxi11.module.core.entity.QueryBean;
import com.xinxi11.module.core.orm.Finder;

public class UserQuerybean extends QueryBean {

	private static final long serialVersionUID = 1L;

	@Override
	public Finder getQueryFinder() {
		Finder finder=new Finder("from User");
		return finder;
	}

}
