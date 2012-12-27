package com.term.business.dto;

public class DefaultValueDto implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String value;

	// Constructors

	/** default constructor */
	public DefaultValueDto() {
	}

	/** full constructor */
	public DefaultValueDto(String id, String name, String value) {
		this.id = id;
		this.name = name;
		this.value = value;
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}