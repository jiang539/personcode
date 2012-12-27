package com.term.common.config;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 获得资源信息
 */
public class Resource {

	private static PropertyResourceBundle properTyResourceBundle;

	private Resource() {
	}

	static {
		properTyResourceBundle = (PropertyResourceBundle) ResourceBundle
				.getBundle("MessageResources", Locale.getDefault());
	}

	/**
	 * 根据key获得对应的value
	 * 
	 * @param strPropertyName
	 *            key
	 * @return String
	 */
	public static String getString(String strPropertyName) {
		try {
			return properTyResourceBundle.getString(strPropertyName);
		} catch (Exception e) {
			return strPropertyName;
		}
	}

	public static String getString(String strPropertyName, Object... obj) {
		String str = properTyResourceBundle.getString(strPropertyName);
		if (str == null) {
			return strPropertyName;
		}
		return MessageFormat.format(str, obj);
	}

	public static PropertyResourceBundle getBundle() {
		return properTyResourceBundle;
	}

	public static void main(String[] args) {
		System.out.println(getString("errors.leave.importException", "sssss",
				"", ""));
	}

}
