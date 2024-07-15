package com.fjulca.reserva.client;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fjulca.reserva.request.DiscountRequest;
import com.fjulca.reserva.response.DiscountResponse;
import com.fjulca.reserva.util.ReservaProperties;

@Component
public class ApiDiscountClient {

	@Autowired
	private ReservaProperties reservaProperties;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public DiscountResponse getObtenerDiscount(DiscountRequest discount)
			throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		String fooResourceUrl = this.reservaProperties.getUrl_api_discount();
		HttpEntity<DiscountRequest> request = new HttpEntity<DiscountRequest>(discount, headers);
		ResponseEntity<DiscountResponse> responseEntity
		  = restTemplate.exchange(fooResourceUrl, HttpMethod.POST,request,
				  DiscountResponse.class);
		return responseEntity.getBody();

	}
	
	
}
