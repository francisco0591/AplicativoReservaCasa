package com.fjulca.reserva.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fjulca.reserva.enums.EstadoRespuesta;
import com.fjulca.reserva.enums.MensajeRespuesta;
import com.fjulca.reserva.request.BookRequest;
import com.fjulca.reserva.request.DiscountRequest;
import com.fjulca.reserva.response.DiscountResponse;
import com.fjulca.reserva.response.ReservaResponse;
import com.fjulca.reserva.service.DiscountService;
import com.fjulca.reserva.service.ReservaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DiscountService discountService;

	@Autowired
	private ReservaService reservaService;

	@PostMapping("/book")
	public ResponseEntity<?> registrarReserva(@Valid @RequestBody BookRequest book, BindingResult result) {
		logger.info("Inicio del servicio registrarReserva");
		ReservaResponse response = new ReservaResponse();
		if (result.hasErrors()) {
			return this.validar(result);
		}
		try {
			DiscountRequest request = new DiscountRequest(book.getId(), book.getHouseId(), book.getDiscountCode());
			DiscountResponse discountResp = discountService.getObtenerBodyDiscount(request);
			if(discountResp == null || discountResp.getDiscountCode() != null || !discountResp.isStatus()) {
				response.setCode(EstadoRespuesta.BAD_REQUEST.getValue());
				response.setError(MensajeRespuesta.MSG_ERROR_CONFLICTO.getStrPv_valor());
				response.setMessage(MensajeRespuesta.MSG_ERROR_INVALIDO_DISCOUNT.getStrPv_valor());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}else{
				response = this.reservaService.registrarReserva(book);
				return ResponseEntity.status(HttpStatus.CREATED).body(response);
			}
		} catch (Exception e) {
			logger.error("Error en el servicio registrarReserva -->" + e);

		}

        return null;
	}

	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		System.out.println("fee22");
		result.getFieldErrors().forEach(
				err -> errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage()));
		return ResponseEntity.badRequest().body(errores);
	}
}
