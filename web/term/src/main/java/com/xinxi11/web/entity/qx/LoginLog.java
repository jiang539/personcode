package com.xinxi11.web.entity.qx;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xinxi11.module.core.entity.IEntity;

/**
 * LoginLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "loginLog")
public class LoginLog implements IEntity<String> {

	private static final long serialVersionUID = 7020358961174728554L;
	private String id;
	private String userId;
	private String userName;
	private Date loginTime;
	private String ip;
	private String os;
	private String explorer;
	private String explorerVersion;

	// Constructors

	/** default constructor */
	public LoginLog() {
	}

	/** minimal constructor */
	public LoginLog(String id) {
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

	@Column(name = "userID", length = 50)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "userName", length = 50)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "loginTime", length = 23)
	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "ip", length = 200)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "os", length = 50)
	public String getOs() {
		return this.os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@Column(name = "explorer", length = 50)
	public String getExplorer() {
		return this.explorer;
	}

	public void setExplorer(String explorer) {
		this.explorer = explorer;
	}

	@Column(name = "explorerVersion", length = 50)
	public String getExplorerVersion() {
		return this.explorerVersion;
	}

	public void setExplorerVersion(String explorerVersion) {
		this.explorerVersion = explorerVersion;
	}

}