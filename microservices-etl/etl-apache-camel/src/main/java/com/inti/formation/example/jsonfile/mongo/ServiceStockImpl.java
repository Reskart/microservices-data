package com.inti.formation.example.jsonfile.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceStockImpl implements ServiceStock {

	@Autowired
	StockRepository stockRepository;

	@Override
	public StockMongo add(StockMongo s) {
		return stockRepository.save(s);
	}

}
