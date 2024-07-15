package com.fjulca.reserva.service;

import com.fjulca.reserva.request.BookRequest;
import com.fjulca.reserva.response.ReservaResponse;

public interface ReservaService {

	public ReservaResponse registrarReserva(BookRequest book);
}
