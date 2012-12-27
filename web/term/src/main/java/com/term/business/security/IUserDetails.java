package com.term.business.security;

import org.springframework.security.userdetails.UserDetails;

/**
 * 用户在会话中保存的信息<br>
 * boolean isAccountNonExpired（）：用户帐号是否过期；<br>
 * boolean isAccountNonLocked（）：用户帐号是否锁定；<br>
 * boolean isCredentialsNonExpired（）：用户的凭证是否过期；<br>
 * boolean isEnabled（）：用户是否处于激活状态。<br>
 * getAuthorities（）获取用户权限信息
 * 
 * @author 李国江
 * @date 2009-4-10 上午09:49:30
 */
public interface IUserDetails extends UserDetails {

	/**
	 * 用户名,汉字
	 * 
	 * @return
	 */
	public String getUserZhName();

	public String getRoleNames();

}
