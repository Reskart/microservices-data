package com.inti.formation.shop.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.StockRepository;
import com.inti.formation.shop.api.repository.model.Stock;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockRepository rep;

	@Override
	public Mono<Stock> add(Stock s) {
		
		return rep.save(s);
	}

	@Override
	public Flux<Stock> searchDate(Date d) {
		
		return rep.findByDate(d);
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
