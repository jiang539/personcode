package com.xinxi11.web.entity.qx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.xinxi11.module.core.entity.RecordSupport;

/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userRole")
public class UserRole extends RecordSupport<String> {

	private static final long serialVersionUID = -5624962354914605583L;

	private String id;
	private String roleId;
	private String userId;

	// Constructors

	/** default constructor */
	public UserRole() {
	}

	/** minimal constructor */
	public UserRole(String id) {
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

	@Column(name = "roleId", length = 50)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "userId")
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}