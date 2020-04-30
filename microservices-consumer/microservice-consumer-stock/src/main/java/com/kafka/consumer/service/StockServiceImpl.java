package com.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kafka.consumer.model.Stock;
import com.kafka.consumer.repositories.StockRepository;

public class StockServiceImpl implements StockService{

	@Autowired
	private StockRepository rep;
	
	@Override
	public Stock add(Stock stock) {
		
		return rep.save(stock);
	}

}
