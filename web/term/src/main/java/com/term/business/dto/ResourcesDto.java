package com.term.business.dto;

import java.util.HashSet;
import java.util.Set;

public class ResourcesDto implements java.io.Serializable {

	// Fields

	private String id;
	private ResourcesDto resourcesDto;
	private String name;
	private String path;
	private String type;
	private String state;
	private String memo;
	private Set<UserResourcesDto> userResourceses = new HashSet<UserResourcesDto>(
			0);
	private Set<RoleResourcesDto> roleResourceses = new HashSet<RoleResourcesDto>(
			0);
	private Set<ResourcesDto> resourceses = new HashSet<ResourcesDto>(0);

	// Constructors

	/** default constructor */
	public ResourcesDto() {
	}

	/** minimal constructor */
	public ResourcesDto(String id, String name, String path) {
		this.id = id;
		this.name = name;
		this.path = path;
	}

	/** full constructor */
	public ResourcesDto(String id, ResourcesDto resourcesDto, String name,
			String path, String type, String state, String memo,
			Set<UserResourcesDto> userresourceses,
			Set<RoleResourcesDto> roleresourceses, Set<ResourcesDto> resourceses) {
		this.id = id;
		this.resourcesDto = resourcesDto;
		this.name = name;
		this.path = path;
		this.type = type;
		this.state = state;
		this.memo = memo;
		this.userResourceses = userresourceses;
		this.roleResourceses = roleresourceses;
		this.resourceses = resourceses;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Set<UserResourcesDto> getUserresourceses() {
		return this.userResourceses;
	}

	public void setUserresourceses(Set<UserResourcesDto> userresourceses) {
		this.userResourceses = userresourceses;
	}

	public Set<RoleResourcesDto> getRoleresourceses() {
		return this.roleResourceses;
	}

	public void setRoleresourceses(Set<RoleResourcesDto> roleresourceses) {
		this.roleResourceses = roleresourceses;
	}

	public Set<ResourcesDto> getResourceses() {
		return this.resourceses;
	}

	public void setResourceses(Set<ResourcesDto> resourceses) {
		this.resourceses = resourceses;
	}

}