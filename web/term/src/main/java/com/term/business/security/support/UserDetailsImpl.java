package com.term.business.security.support;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.User;

import com.term.business.security.IUserDetails;

/**
 * boolean isAccountNonExpired（）：用户帐号是否过期；<br>
 * boolean isAccountNonLocked（）：用户帐号是否锁定；<br>
 * boolean isCredentialsNonExpired（）：用户的凭证是否过期；<br>
 * boolean isEnabled（）：用户是否处于激活状态。<br>
 * getAuthorities（）获取用户权限信息
 * 
 * @author 李国江
 * @date 2009-2-5
 */
public class UserDetailsImpl extends User implements IUserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userZhName;// 用户名,汉字

	public UserDetailsImpl(String username, String userZhName, String password,
			boolean enabled, GrantedAuthority[] authorities)
			throws IllegalArgumentException {
		super(username, password, enabled, authorities);
		this.userZhName = userZhName;
	}

	/**
	 * 用户名,汉字
	 * 
	 * @return
	 */
	public String getUserZhName() {
		return this.userZhName;
	}

	@Override
	public String getRoleNames() {
		return StringUtils.join(getAuthorities(), ",");
	}

}
