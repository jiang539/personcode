package com.term.business.core;

import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;

import com.term.business.security.IUserDetails;

public class BaseDto implements IBaseDto {

	private static final long serialVersionUID = 1L;
	private IUserDetails userDetails;

	public BaseDto() {
		Object obj = SecurityContextHolder.getContext().getAuthentication();
		if (obj != null) {
			Authentication aut = (Authentication) obj;
			Object userDetail = aut.getPrincipal();
			if (userDetail instanceof IUserDetails) {
				setUserDetails((IUserDetails) userDetail);
			}
		}
	}

	public IUserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(IUserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
