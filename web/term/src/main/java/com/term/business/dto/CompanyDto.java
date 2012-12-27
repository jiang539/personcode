package com.term.business.dto;

import java.util.HashSet;
import java.util.Set;

public class CompanyDto implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String phone;
	private String linkman;
	private String email;
	private String address;
	private String type="客户";
	private Integer state;
	private Set<ShangPinDto> shangPinDtos = new HashSet<ShangPinDto>(0);

	// Constructors

	/** default constructor */
	public CompanyDto() {
	}

	/** minimal constructor */
	public CompanyDto(String id) {
		this.id = id;
	}

	/** full constructor */
	public CompanyDto(String id, String name, String phone, String linkman,
			String email, String address, String type, Integer state,
			Set<ShangPinDto> shangPinDtos) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.linkman = linkman;
		this.email = email;
		this.address = address;
		this.type = type;
		this.state = state;
		this.shangPinDtos = shangPinDtos;
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set<ShangPinDto> getShangpins() {
		return this.shangPinDtos;
	}

	public void setShangpins(Set<ShangPinDto> shangPinDtos) {
		this.shangPinDtos = shangPinDtos;
	}

}