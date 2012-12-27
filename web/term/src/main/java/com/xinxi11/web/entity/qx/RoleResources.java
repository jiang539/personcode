package com.xinxi11.web.entity.qx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.xinxi11.module.core.entity.RecordSupport;

/**
 * RoleResources entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "roleResources")
public class RoleResources extends RecordSupport<String> {

	private static final long serialVersionUID = 8675030854011547754L;

	private Role role;
	private Resources resources;
	private String operationIds;
	private String fieldIds;

	// Constructors

	/** default constructor */
	public RoleResources() {
	}

	/** minimal constructor */
	public RoleResources(String id) {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resourcesId")
	public Resources getResources() {
		return resources;
	}

	public void setResources(Resources resources) {
		this.resources = resources;
	}

	@Column(name = "operationIds", length = 1000)
	public String getOperationIds() {
		return this.operationIds;
	}

	public void setOperationIds(String operationIds) {
		this.operationIds = operationIds;
	}

	@Column(name = "fieldIds", length = 2000)
	public String getFieldIds() {
		return this.fieldIds;
	}

	public void setFieldIds(String fieldIds) {
		this.fieldIds = fieldIds;
	}

}