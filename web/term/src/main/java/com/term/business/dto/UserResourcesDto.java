package com.term.business.dto;

public class UserResourcesDto implements java.io.Serializable {

	// Fields

	private String id;
	private ResourcesDto resourcesDto;
	private UserDto userDto;
	private Integer state;

	// Constructors

	/** default constructor */
	public UserResourcesDto() {
	}

	/** minimal constructor */
	public UserResourcesDto(String id, ResourcesDto resourcesDto,
			UserDto userDto) {
		this.id = id;
		this.resourcesDto = resourcesDto;
		this.userDto = userDto;
	}

	/** full constructor */
	public UserResourcesDto(String id, ResourcesDto resourcesDto,
			UserDto userDto, Integer state) {
		this.id = id;
		this.resourcesDto = resourcesDto;
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

	public ResourcesDto getResources() {
		return this.resourcesDto;
	}

	public void setResources(ResourcesDto resourcesDto) {
		this.resourcesDto = resourcesDto;
	}

	public UserDto getUser() {
		return this.userDto;
	}

	public void setUser(UserDto userDto) {
		this.userDto = userDto;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}