package com.term.business.dto;

import java.io.Serializable;

public class KuCunDto implements Serializable {

	private String spId;
	private String spName;
	private Long ruKunAmount = 0L;// 入库数量
	private Long chuKuAmount = 0L;// 出库数量
	private Long kuCunAmount = 0L;// 库存数量

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public Long getRuKunAmount() {
		return ruKunAmount;
	}

	public void setRuKunAmount(Long ruKunAmount) {
		this.ruKunAmount = (ruKunAmount == null ? 0 : ruKunAmount);
	}

	public Long getChuKuAmount() {
		return chuKuAmount;
	}

	public void setChuKuAmount(Long chuKuAmount) {
		this.chuKuAmount = (chuKuAmount == null ? 0 : chuKuAmount);
	}

	public Long getKuCunAmount() {
		kuCunAmount = ruKunAmount - chuKuAmount;
		return kuCunAmount;
	}

}
