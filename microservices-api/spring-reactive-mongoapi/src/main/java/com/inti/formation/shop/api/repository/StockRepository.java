package com.inti.formation.shop.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.inti.formation.shop.api.repository.model.Stock;

public interface StockRepository extends ReactiveMongoRepository<Stock, String>{

}
