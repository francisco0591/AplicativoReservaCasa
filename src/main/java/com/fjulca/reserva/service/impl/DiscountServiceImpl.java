package com.fjulca.reserva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fjulca.reserva.client.ApiDiscountClient;
import com.fjulca.reserva.request.DiscountRequest;
import com.fjulca.reserva.response.DiscountResponse;
import com.fjulca.reserva.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService{

	@Autowired
	private ApiDiscountClient apiDiscountClient;
	
	@Override
	public DiscountResponse getObtenerBodyDiscount(DiscountRequest discount) throws JsonProcessingException {
		return apiDiscountClient.getObtenerDiscount(discount);
	}

}
