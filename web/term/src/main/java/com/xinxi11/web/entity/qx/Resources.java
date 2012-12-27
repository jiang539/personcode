package com.xinxi11.web.entity.qx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.xinxi11.module.core.entity.RecordSupport;

/**
 * Resources entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resources")
public class Resources extends RecordSupport<String> {

	private static final long serialVersionUID = 2491009818810443089L;

	private String name;
	private String alias;
	private Integer level;
	private Integer sort;
	private String mask;
	private Resources parentResources;
	private String version;
	private Integer operationType;
	private String pageUrl;
	private String submitUrl;
	private Integer desplay;
	private Integer hasCustom;
	private String operationIds;
	private String tableIds;
	private String fieldIds;

	// Constructors

	/** default constructor */
	public Resources() {
	}

	/** minimal constructor */
	public Resources(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "alias", length = 50)
	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "sort")
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Column(name = "mask", length = 200)
	public String getMask() {
		return this.mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentId")
	public Resources getParentResources() {
		return parentResources;
	}

	public void setParentResources(Resources parentResources) {
		this.parentResources = parentResources;
	}

	@Column(name = "version", length = 50)
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "operationType")
	public Integer getOperationType() {
		return this.operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	@Column(name = "pageUrl", length = 200)
	public String getPageUrl() {
		return this.pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	@Column(name = "submitUrl", length = 200)
	public String getSubmitUrl() {
		return this.submitUrl;
	}

	public void setSubmitUrl(String submitUrl) {
		this.submitUrl = submitUrl;
	}

	@Column(name = "desplay")
	public Integer getDesplay() {
		return this.desplay;
	}

	public void setDesplay(Integer desplay) {
		this.desplay = desplay;
	}

	@Column(name = "hasCustom")
	public Integer getHasCustom() {
		return this.hasCustom;
	}

	public void setHasCustom(Integer hasCustom) {
		this.hasCustom = hasCustom;
	}

	@Column(name = "operationIds", length = 1000)
	public String getOperationIds() {
		return this.operationIds;
	}

	public void setOperationIds(String operationIds) {
		this.operationIds = operationIds;
	}

	@Column(name = "tableIds", length = 1000)
	public String getTableIds() {
		return this.tableIds;
	}

	public void setTableIds(String tableIds) {
		this.tableIds = tableIds;
	}

	@Column(name = "fieldIds", length = 2000)
	public String getFieldIds() {
		return this.fieldIds;
	}

	public void setFieldIds(String fieldIds) {
		this.fieldIds = fieldIds;
	}

}