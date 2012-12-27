package com.xinxi11.web.entity.qx;

import java.util.Date;

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
 * UserDepartment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userDepartment")
public class UserDepartment extends RecordSupport<String> {

	private static final long serialVersionUID = 6682036391973849622L;

	private User user;
	private Department department;
	private Date enterTime;
	private Date leaveTime;

	// Constructors

	/** default constructor */
	public UserDepartment() {
	}

	/** minimal constructor */
	public UserDepartment(String id) {
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
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departmentID")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "enterTime", length = 23)
	public Date getEnterTime() {
		return this.enterTime;
	}

	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
	}

	@Column(name = "leaveTime", length = 23)
	public Date getLeaveTime() {
		return this.leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

}