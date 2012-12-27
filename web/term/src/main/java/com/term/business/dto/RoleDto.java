package com.term.business.dto;

import java.util.HashSet;
import java.util.Set;

public class RoleDto implements java.io.Serializable {

	// Fields

	private String id;
	private RoleDto roleDto;
	private String name;
	private String type;
	private String memo;
	private Set<RoleDto> roleDtos = new HashSet<RoleDto>(0);
	private Set<UserRoleDto> userRoleDtos = new HashSet<UserRoleDto>(0);
	private Set<RoleResourcesDto> roleresourceses = new HashSet<RoleResourcesDto>(
			0);

	// Constructors

	/** default constructor */
	public RoleDto() {
	}

	/** minimal constructor */
	public RoleDto(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public RoleDto(String id, RoleDto roleDto, String name, String type,
			String memo, Set<RoleDto> roleDtos, Set<UserRoleDto> userRoleDtos,
			Set<RoleResourcesDto> roleresourceses) {
		this.id = id;
		this.roleDto = roleDto;
		this.name = name;
		this.type = type;
		this.memo = memo;
		this.roleDtos = roleDtos;
		this.userRoleDtos = userRoleDtos;
		this.roleresourceses = roleresourceses;
	}

	// Property accessors
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RoleDto getRole() {
		return this.roleDto;
	}

	public void setRole(RoleDto roleDto) {
		this.roleDto = roleDto;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Set<RoleDto> getRoles() {
		return this.roleDtos;
	}

	public void setRoles(Set<RoleDto> roleDtos) {
		this.roleDtos = roleDtos;
	}

	public Set<UserRoleDto> getUserroles() {
		return this.userRoleDtos;
	}

	public void setUserroles(Set<UserRoleDto> userRoleDtos) {
		this.userRoleDtos = userRoleDtos;
	}

	public Set<RoleResourcesDto> getRoleresourceses() {
		return this.roleresourceses;
	}

	public void setRoleresourceses(Set<RoleResourcesDto> roleresourceses) {
		this.roleresourceses = roleresourceses;
	}

}