package com.fjulca.reserva.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fjulca.reserva.entity.Book;

public interface ReservaRepositorioDao extends CrudRepository<Book,String >{

	@Query ("select b from Book b where b.userId=?1")
	Book findByUserId(String userId);
}
