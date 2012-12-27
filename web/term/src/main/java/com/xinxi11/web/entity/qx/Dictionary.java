package com.xinxi11.web.entity.qx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.xinxi11.module.core.entity.RecordSupport;

/**
 * Dictionary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dictionary")
public class Dictionary extends RecordSupport<String> {

	private static final long serialVersionUID = 8122657303972836591L;
	private Integer type;
	private String code;
	private String name;
	private String value;

	// Constructors

	/** default constructor */
	public Dictionary() {
	}

	/** minimal constructor */
	public Dictionary(String id) {
		this.id = id;
	}

	// UUID设置
	@Id
	@Column(nullable = false, updatable = false, length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
	public String getId() {
		return this.id;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "code", length = 50)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "value")
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}