package com.term.business.dto;

public class UserRoleDto implements java.io.Serializable {

	// Fields

	private String id;
	private RoleDto roleDto;
	private UserDto userDto;
	private Integer state;

	// Constructors

	/** default constructor */
	public UserRoleDto() {
	}

	/** minimal constructor */
	public UserRoleDto(String id, RoleDto roleDto, UserDto userDto) {
		this.id = id;
		this.roleDto = roleDto;
		this.userDto = userDto;
	}

	/** full constructor */
	public UserRoleDto(String id, RoleDto roleDto, UserDto userDto,
			Integer state) {
		this.id = id;
		this.roleDto = roleDto;
		this.userDto = userDto;
		this.state = state;
	}

	// Property accessors
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RoleDto getRoleDto() {
		return roleDto;
	}

	public void setRoleDto(RoleDto roleDto) {
		this.roleDto = roleDto;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}