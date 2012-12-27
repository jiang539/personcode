package com.term.business.core;

import java.io.Serializable;

/**
 * 主要供struts2的list控件使用
 * 
 * @author 李国江
 * @date 2009-5-6 下午05:46:20
 */
public class ListDto implements Serializable {

	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
