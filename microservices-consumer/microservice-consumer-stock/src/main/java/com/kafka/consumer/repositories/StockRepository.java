package com.kafka.consumer.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;
import com.kafka.consumer.model.Stock;

import java.util.List;

@Repository
public interface StockRepository extends ElasticsearchCrudRepository<Long, Stock> {

	
}
