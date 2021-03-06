package com.inti.formation.shop.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.StockRepository;
import com.inti.formation.shop.api.repository.model.Stock;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author Antoine Bertin, Marion Gloriant
 */

@Component
@Slf4j
public class StockServiceImpl implements StockService{
	


	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public Mono<Stock> add(final Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Flux<Stock> searchActiveSinceDate(final Date d) {
		
		return stockRepository.findActiveStockSinceDate(d);
	}


	@Override
	public Mono<Stock> update(final Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Flux<Stock> findAll() {
		return stockRepository.findAll();
	}


	@Override
	public Mono<Void> delete(Stock s) {
		return stockRepository.delete(s);
	}

	@Override
	public Mono<Void> deleteById(Long id) {
	
		return stockRepository.deleteById(id);
	}

	@Override
	public Mono<Stock> findById(Long id) {
		
		return stockRepository.findById(id);
	}

}
