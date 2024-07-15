package com.fjulca.reserva.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="BOOK")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID" , unique = true , nullable = true)
	private String id;
	
	@Column(name="USERID")
	private String userId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="PHONENUMBER")
	private String phoneNumber;
	
	@Column(name="STARTDATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name="ENDDATE")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Column(name="HOUSEID")
	private String houseId;
	
	@Column(name="DISCOUNTCODE")
	private String discountCode;

	
	public Book() {
	}


	public Book(String id, String userId, String name, String lastName, int age, String phoneNumber, Date startDate,
			Date endDate, String houseId, String discountCode) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.houseId = houseId;
		this.discountCode = discountCode;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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
