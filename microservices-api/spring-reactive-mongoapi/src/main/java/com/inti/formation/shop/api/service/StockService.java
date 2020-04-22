package com.inti.formation.shop.api.service;

import java.util.Date;

import com.inti.formation.shop.api.repository.model.Stock;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StockService {
	
	public Mono<Stock> add(Stock s);
	
	public Flux<Stock> searchDate(Date d);
	
	public Mono<Stock> update(Stock s);
	
	public Flux<Stock> findAll();

}