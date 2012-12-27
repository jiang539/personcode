package com.term.dbaccess.querybean;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 查询bean
 */
public class ShangPinQueryBean {

	private Date startDate;// 开始时间
	private Date endDate;// 结束时间
	private String spType;// 商品类型
	private String spId;// 商品Id
	private String userId;// 用户Id
	private String companyId;// 厂商id

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSpType() {
		return spType;
	}

	public void setSpType(String spType) {
		this.spType = spType;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
		if (StringUtils.isBlank(spId)) {
			this.spId = null;
		}
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
