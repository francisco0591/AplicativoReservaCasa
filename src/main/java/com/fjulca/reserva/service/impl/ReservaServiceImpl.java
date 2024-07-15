package com.fjulca.reserva.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fjulca.reserva.dao.ReservaRepositorioDao;
import com.fjulca.reserva.entity.Book;
import com.fjulca.reserva.enums.EstadoRespuesta;
import com.fjulca.reserva.enums.MensajeRespuesta;
import com.fjulca.reserva.request.BookRequest;
import com.fjulca.reserva.response.ReservaResponse;
import com.fjulca.reserva.service.ReservaService;
import com.fjulca.reserva.util.Constante;

@Service
public class ReservaServiceImpl implements ReservaService{
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	
	@Autowired
	private ReservaRepositorioDao reservaRepositorioDao;

	@SuppressWarnings("unused")
	@Override
	public ReservaResponse registrarReserva(BookRequest book) {
		logger.info("Inicio del metodo services registrarReserva");
		Book b = reservaRepositorioDao.findByUserId(book.getId());
		Book bookEntity = new Book();
		ReservaResponse response = new ReservaResponse();
		if(b != null) {
			response.setCode(EstadoRespuesta.ERROR_REQUEST.getValue());
			response.setMessage(Constante.MENSAJE_REGISTRO_INICIAL+ book.getId() + Constante.MENSAJE_REGISTRO_FINAL);
		}else {
			bookEntity.setUserId(book.getId());
			bookEntity.setName(book.getName());
			bookEntity.setLastName(book.getLastName());
			bookEntity.setPhoneNumber(book.getPhoneNumber());
			bookEntity.setStartDate(book.getStartDate());
			bookEntity.setEndDate(book.getEndDate());
			bookEntity.setHouseId(book.getHouseId());
			bookEntity.setDiscountCode(book.getDiscountCode());
			this.reservaRepositorioDao.save(bookEntity);
			response.setCode(EstadoRespuesta.OK.getValue());
			response.setMessage(MensajeRespuesta.MSG_OK_REGISTRO.getStrPv_valor());
		}
		logger.info("Fin del metodo services registrarReserva");
		return response;
	}

}
