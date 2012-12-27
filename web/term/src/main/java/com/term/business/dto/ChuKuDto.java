package com.term.business.dto;

import java.util.Date;

public class ChuKuDto implements java.io.Serializable {

	// Fields

	private String id;
	private ShangPinDto shangPinDto;
	private UserDto userDto;
	private Double price;
	private Integer amount;
	private Double payment;
	private Date date;

	private Double totalMoney;

	// Constructors

	/** default constructor */
	public ChuKuDto() {
	}

	/** minimal constructor */
	public ChuKuDto(String id, ShangPinDto shangPinDto) {
		this.id = id;
		this.shangPinDto = shangPinDto;
	}

	/** full constructor */
	public ChuKuDto(String id, ShangPinDto shangPinDto, UserDto userDto,
			Double price, Integer amount, Double payment, Date data) {
		this.id = id;
		this.shangPinDto = shangPinDto;
		this.userDto = userDto;
		this.price = price;
		this.amount = amount;
		this.payment = payment;
		this.date = data;
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

	public Double getPayment() {
		return this.payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Double getTotalMoney() {
		if (price == null || amount == null) {
			return 0.0;
		}
		return price * amount;
	}

}