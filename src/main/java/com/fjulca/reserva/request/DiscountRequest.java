package com.fjulca.reserva.request;

import java.io.Serializable;

public class DiscountRequest implements Serializable{

	private String userId;
	private String houseId;
	private String discountCode;
	
	
	public DiscountRequest(String userId, String houseId, String discountCode) {
		super();
		this.userId = userId;
		this.houseId = houseId;
		this.discountCode = discountCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
