package com.term.business.dto;

import java.util.HashSet;
import java.util.Set;

public class ShangPinDto implements java.io.Serializable {

	// Fields

	private String id;
	private CompanyDto companyDto;
	private String name;
	private String type;
	private String memo;
	private Set<ChuKuDto> chukus = new HashSet<ChuKuDto>(0);
	private Set<RuKuDto> ruKuDtos = new HashSet<RuKuDto>(0);

	// Constructors

	/** default constructor */
	public ShangPinDto() {
	}

	/** minimal constructor */
	public ShangPinDto(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public ShangPinDto(String id, CompanyDto companyDto, String name,
			String type, String memo, Set<ChuKuDto> chukus,
			Set<RuKuDto> ruKuDtos) {
		this.id = id;
		this.companyDto = companyDto;
		this.name = name;
		this.type = type;
		this.memo = memo;
		this.chukus = chukus;
		this.ruKuDtos = ruKuDtos;
	}

	// Property accessors
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CompanyDto getCompanyDto() {
		return companyDto;
	}

	public void setCompanyDto(CompanyDto companyDto) {
		this.companyDto = companyDto;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Set<ChuKuDto> getChukus() {
		return this.chukus;
	}

	public void setChukus(Set<ChuKuDto> chukus) {
		this.chukus = chukus;
	}

	public Set<RuKuDto> getRuKuDtos() {
		return ruKuDtos;
	}

	public void setRuKuDtos(Set<RuKuDto> ruKuDtos) {
		this.ruKuDtos = ruKuDtos;
	}

}