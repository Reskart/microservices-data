package com.inti.formation.shop.api.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.inti.formation.shop.api.repository.model.Stock;

import reactor.core.publisher.Flux;

public interface StockRepository extends ReactiveMongoRepository<Stock, String>{

	
	@Query("{'date':?0}")
	Flux<Stock> findByDate(Date d);

}
