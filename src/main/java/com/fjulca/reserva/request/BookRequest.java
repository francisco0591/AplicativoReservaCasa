package com.fjulca.reserva.request;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class BookRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty(message = "campo id requerido.")
	private String id;
	
	@NotEmpty(message = "campo name requerido.")
	private String name;
	
	@NotEmpty(message = "campo lastName  requerido.")
	private String lastName;
	
	private int age;
	
	@NotEmpty(message = "campo phoneNumber requerido.")
	private String phoneNumber;
	
	@NotNull(message = "campo startDate requerido.")
	private Date startDate;
	
	@NotNull(message = "campo endDate requerido.")
	private Date endDate;
	
	@NotEmpty(message = "campo houseId requerido.")
	private String houseId;
	
	@NotEmpty(message = "campo houseId requerido.")
	private String discountCode;
	
	public BookRequest() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

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

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	
	
	
}
