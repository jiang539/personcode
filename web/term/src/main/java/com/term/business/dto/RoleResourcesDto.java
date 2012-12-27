package com.term.business.dto;

public class RoleResourcesDto implements java.io.Serializable {

	// Fields

	private String id;
	private RoleDto roleDto;
	private ResourcesDto resourcesDto;
	private Integer state;

	// Constructors

	/** default constructor */
	public RoleResourcesDto() {
	}

	/** minimal constructor */
	public RoleResourcesDto(String id, RoleDto roleDto,
			ResourcesDto resourcesDto) {
		this.id = id;
		this.roleDto = roleDto;
		this.resourcesDto = resourcesDto;
	}

	/** full constructor */
	public RoleResourcesDto(String id, RoleDto roleDto,
			ResourcesDto resourcesDto, Integer state) {
		this.id = id;
		this.roleDto = roleDto;
		this.resourcesDto = resourcesDto;
		this.state = state;
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

	public ResourcesDto getResources() {
		return this.resourcesDto;
	}

	public void setResources(ResourcesDto resourcesDto) {
		this.resourcesDto = resourcesDto;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}