package com.term.business.service.power.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.term.business.core.BaseServiceImpl;
import com.term.business.dto.RoleDto;
import com.term.business.dto.UserDto;
import com.term.business.dto.UserRoleDto;
import com.term.business.service.power.IUserRoleService;
import com.term.dbaccess.dao.power.IUserRoleDao;
import com.xinxi11.web.entity.qx.Role;
import com.xinxi11.web.entity.qx.User;
import com.xinxi11.web.entity.qx.UserRole;

@Service("userRoleService")
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleDto, UserRole>
		implements IUserRoleService {
	private IUserRoleDao userRoleDao;

	@Autowired
	public void setUserRoleDao(IUserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
		this.baseHibernateDao = userRoleDao;
	}

	@Override
	protected UserRole dtoToEntity(UserRoleDto dto) {
		UserRole userRole = new UserRole();
		userRole.setId(dto.getId());

		User user = new User();
		user.setId(dto.getUserDto().getId());
		userRole.setUser(user);

		Role role = new Role();
		role.setId(dto.getRoleDto().getId());
		userRole.setRole(role);
		return userRole;
	}

	@Override
	protected UserRoleDto entityToDto(UserRole entity) {
		UserRoleDto userRoleDto = new UserRoleDto();
		userRoleDto.setId(entity.getId());

		UserDto userDto = new UserDto();
		userDto.setId(entity.getUser().getId());
		userDto.setName(entity.getUser().getName());
		userRoleDto.setUserDto(userDto);

		RoleDto roleDto = new RoleDto();
		roleDto.setId(entity.getRole().getId());
		roleDto.setName(entity.getRole().getName());
		userRoleDto.setRoleDto(roleDto);

		return userRoleDto;
	}

}
