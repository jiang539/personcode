package com.term.business.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDto implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String password;
	private String sex="男";
	private String email;
	private String phone;
	private String address;
	private Integer active;
	private Integer state;
	private Set<ChuKuDto> chukus = new HashSet<ChuKuDto>(0);
	private Set<UserResourcesDto> userresourceses = new HashSet<UserResourcesDto>(
			0);
	private Set<UserRoleDto> userRoleDtos = new HashSet<UserRoleDto>(0);
	private Set<RuKuDto> ruKuDtos = new HashSet<RuKuDto>(0);

	// Constructors

	/** default constructor */
	public UserDto() {
	}

	/** minimal constructor */
	public UserDto(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public UserDto(String id, String name, String password, String sex,
			String email, String phone, String address, Integer active,
			Integer state, Set<ChuKuDto> chukus,
			Set<UserResourcesDto> userresourceses,
			Set<UserRoleDto> userRoleDtos, Set<RuKuDto> ruKuDtos) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.active = active;
		this.state = state;
		this.chukus = chukus;
		this.userresourceses = userresourceses;
		this.userRoleDtos = userRoleDtos;
		this.ruKuDtos = ruKuDtos;
	}

	// Property accessors
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set<ChuKuDto> getChukus() {
		return this.chukus;
	}

	public void setChukus(Set<ChuKuDto> chukus) {
		this.chukus = chukus;
	}

	public Set<UserResourcesDto> getUserresourceses() {
		return this.userresourceses;
	}

	public void setUserresourceses(Set<UserResourcesDto> userresourceses) {
		this.userresourceses = userresourceses;
	}

	public Set<UserRoleDto> getUserroles() {
		return this.userRoleDtos;
	}

	public void setUserroles(Set<UserRoleDto> userRoleDtos) {
		this.userRoleDtos = userRoleDtos;
	}

	public Set<RuKuDto> getRukus() {
		return this.ruKuDtos;
	}

	public void setRukus(Set<RuKuDto> ruKuDtos) {
		this.ruKuDtos = ruKuDtos;
	}

}