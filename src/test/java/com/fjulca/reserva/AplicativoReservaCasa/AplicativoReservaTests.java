package com.fjulca.reserva.AplicativoReservaCasa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fjulca.reserva.dao.ReservaRepositorioDao;
import com.fjulca.reserva.entity.Book;
import com.fjulca.reserva.request.DiscountRequest;
import com.fjulca.reserva.response.DiscountResponse;
import com.fjulca.reserva.service.DiscountService;
import com.fjulca.reserva.util.ReservaProperties;

@SpringBootTest
class AplicativoReservaTests {

	@Autowired
	private DiscountService discountService;

	@Autowired
	private ReservaRepositorioDao reservaRepositorioDao;

	@Autowired
	private ReservaProperties reservaProperties;
	
	@Test
	@Disabled
	void saveReserva() {
		Book bookEntity = new Book();
		bookEntity.setUserId("14564088-8");
		bookEntity.setName("Juan");
		bookEntity.setLastName("Sanchez");
		bookEntity.setPhoneNumber("12343212");
		bookEntity.setStartDate(null);
		bookEntity.setEndDate(null);
		bookEntity.setHouseId("213132");
		bookEntity.setDiscountCode("D0542A23");
		Book book = this.reservaRepositorioDao.save(bookEntity);
		assertNotNull(book);
	}

	@Test
	void getObtenerApiDiscount() {
		DiscountRequest discount = new DiscountRequest("14564088-4", "213132", "D0542A23");
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		String fooResourceUrl = this.reservaProperties.getUrl_api_discount();
		HttpEntity<DiscountRequest> request = new HttpEntity<DiscountRequest>(discount, headers);
		ResponseEntity<DiscountResponse> responseEntity
		  = restTemplate.exchange(fooResourceUrl, HttpMethod.POST,request,
				  DiscountResponse.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

}
