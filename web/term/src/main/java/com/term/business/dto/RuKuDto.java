package com.term.business.dto;

import java.util.Date;

public class RuKuDto implements java.io.Serializable {

	// Fields

	private String id;
	private ShangPinDto shangPinDto;
	private UserDto userDto;
	private Double price;
	private Integer amount;
	private Date date;

	// Constructors

	/** default constructor */
	public RuKuDto() {
	}

	/** minimal constructor */
	public RuKuDto(String id, ShangPinDto shangPinDto) {
		this.id = id;
		this.shangPinDto = shangPinDto;
	}

	/** full constructor */
	public RuKuDto(String id, ShangPinDto shangPinDto, UserDto userDto,
			Double price, Integer amount, Date date) {
		this.id = id;
		this.shangPinDto = shangPinDto;
		this.userDto = userDto;
		this.price = price;
		this.amount = amount;
		this.date = date;
	}

	// Property accessors
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ShangPinDto getShangPinDto() {
		return shangPinDto;
	}

	public void setShangPinDto(ShangPinDto shangPinDto) {
		this.shangPinDto = shangPinDto;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}