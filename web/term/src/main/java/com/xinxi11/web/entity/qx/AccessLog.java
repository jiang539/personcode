package com.xinxi11.web.entity.qx;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xinxi11.module.core.entity.IEntity;

/**
 * AccessLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "accessLog")
public class AccessLog implements IEntity<String> {

	private static final long serialVersionUID = 5255325764502636925L;
	private String id;
	private String userId;
	private String userName;
	private Timestamp accessTime;
	private String result;
	private String url;
	private String title;
	private String failCause;

	// Constructors

	/** default constructor */
	public AccessLog() {
	}

	/** minimal constructor */
	public AccessLog(String id) {
		this.id = id;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 48)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "userId", length = 50)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "userName", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "accessTime", length = 23)
	public Timestamp getAccessTime() {
		return this.accessTime;
	}

	public void setAccessTime(Timestamp accessTime) {
		this.accessTime = accessTime;
	}

	@Column(name = "result", length = 10)
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Column(name = "url", length = 500)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "title", length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "failCause", length = 200)
	public String getFailCause() {
		return this.failCause;
	}

	public void setFailCause(String failCause) {
		this.failCause = failCause;
	}

}