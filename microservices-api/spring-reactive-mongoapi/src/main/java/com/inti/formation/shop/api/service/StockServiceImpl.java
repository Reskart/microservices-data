package com.inti.formation.shop.api.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.model.Stock;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class StockServiceImpl implements StockService{

	@Override
	public Mono<Stock> add(Stock s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Stock> searchDate(Date d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Stock> update(Stock s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Stock> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
