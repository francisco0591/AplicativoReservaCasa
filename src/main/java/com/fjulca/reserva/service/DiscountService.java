package com.fjulca.reserva.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fjulca.reserva.request.DiscountRequest;
import com.fjulca.reserva.response.DiscountResponse;

public interface DiscountService {

	public DiscountResponse getObtenerBodyDiscount(DiscountRequest discount) throws JsonProcessingException;
}
