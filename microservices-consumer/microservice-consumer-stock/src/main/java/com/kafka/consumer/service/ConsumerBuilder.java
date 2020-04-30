package com.kafka.consumer.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.consumer.model.Stock;

@Service
@Slf4j
public class ConsumerBuilder {
	
	@Autowired
	private StockService sS;

	@KafkaListener(topics = "${kafka.topic-name}", groupId = "${kafka.consumer-group-id}")
	public void consume(Stock stock) {
		log.info("Stock readed " + stock.toString() );
		sS.add(stock);
	}
}
