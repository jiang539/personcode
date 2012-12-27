package com.term.business.security;

import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;

/**
 * 获取当前用户基本信息
 * 
 * @author 李国江
 * @date 2009-4-10 上午10:31:28
 */
public class UserHolder {

	public static IUserDetails getCurrentUser() {
		Object obj = SecurityContextHolder.getContext().getAuthentication();
		if (obj != null) {
			Authentication aut = (Authentication) obj;
			Object userDetail = aut.getPrincipal();
			if (userDetail instanceof IUserDetails) {
				return (IUserDetails) aut.getPrincipal();
			}
		}
		return null;
	}

}
