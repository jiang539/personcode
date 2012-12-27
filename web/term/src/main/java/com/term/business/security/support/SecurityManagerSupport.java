package com.term.business.security.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.security.ConfigAttributeDefinition;
import org.springframework.security.ConfigAttributeEditor;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.intercept.web.RequestKey;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.term.business.dto.ResourcesDto;
import com.term.business.dto.RoleDto;
import com.term.business.dto.UserDto;
import com.term.business.security.ISecurityManager;
import com.term.business.security.IUserDetails;
import com.term.business.service.power.IResourcesService;
import com.term.business.service.power.IRoleService;
import com.term.business.service.power.IUserService;

/**
 * 用户信息认证,及获取资源
 * 
 * @author 李国江
 * @date 2009-2-5
 */
@Service("securityManager")
public class SecurityManagerSupport implements UserDetailsService,
		ISecurityManager {

	private IUserService userService;
	private IRoleService roleService;
	private IResourcesService resourcesService;

	@Override
	public IUserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException, DataAccessException {
		UserDto userDto = userService.findById(userId);
		if (userDto == null) {
			throw new UsernameNotFoundException(userId + " 不存在");
		}
		// 用户角色
		List<RoleDto> listRole = roleService.findByUserIdForList(userId);
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(
				listRole.size());
		for (RoleDto roleDto : listRole) {
			grantedAuthorities.add(new GrantedAuthorityImpl(roleDto.getName()));
		}
		GrantedAuthority[] authorities = grantedAuthorities
				.toArray(new GrantedAuthority[listRole.size()]);

		return new UserDetailsImpl(userDto.getId(), userDto.getName(), userDto
				.getPassword(), true, authorities);
	}

	/**
	 * 封装url相应的角色<br>
	 * url:roles
	 * 
	 * @return
	 */
	public LinkedHashMap<RequestKey, ConfigAttributeDefinition> loadUrlAuthorities() {
		Map<String, String> urlAuthorities = new HashMap<String, String>();
		LinkedHashMap<RequestKey, ConfigAttributeDefinition> requestMap = new LinkedHashMap<RequestKey, ConfigAttributeDefinition>();
		ConfigAttributeEditor editor = new ConfigAttributeEditor();
		List<ResourcesDto> urlResources = resourcesService.findByType("URL");
		for (ResourcesDto resource : urlResources) {
			urlAuthorities.put(resource.getPath(), resourcesService
					.findByResourcesIdForString(resource.getId()));
			RequestKey key = new RequestKey(resource.getPath(), null);
			editor.setAsText(resource.getName());
			requestMap.put(key, (ConfigAttributeDefinition) editor.getValue());
		}
		return null;
	}

	@Override
	public Map<String, String> loadStringUrlAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
