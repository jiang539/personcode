package com.xinxi11.module.core.entity;

import java.io.Serializable;

import com.xinxi11.module.core.cache.LoginUserInfo;
import com.xinxi11.module.core.orm.Finder;

/**
 * 公共的查询bean
 */
public interface IQueryBean extends Serializable {

	/** 当前使用用户的信息 */
	public LoginUserInfo getLoginUserInfo();

	/**	  
	 * 将查询对象封装为finder对象,方便调用<br />
	 * 如果此查询Bean中需要封装多个finder,则此方法可以使用case进行跳转
	 */
	public Finder getQueryFinder();

}
