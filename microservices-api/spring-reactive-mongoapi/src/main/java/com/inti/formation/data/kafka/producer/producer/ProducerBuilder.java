package com.inti.formation.data.kafka.producer.producer;


import com.inti.formation.shop.api.repository.model.Stock;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;


/**
 * 
 * @author Sylvanius Kouandongui
 *
 */
@Slf4j
@Component
@EnableConfigurationProperties
@EnableAutoConfiguration
public class ProducerBuilder {

//    @Value("${kafka.topic-name}")
    private String TOPIC="stock-v1";

    @Autowired
    private KafkaTemplate<Long, Stock> kafkaTemplate;

    @Value("${kafka.compression-type}")
    private String compressionType;

    
    

    //milliseconds
    
    public void sendK(Stock s) {
        ProducerRecord<Long, Stock> producerRecord = new ProducerRecord<>(TOPIC, s.getIdStock(), s);
	    kafkaTemplate.send(producerRecord);
    }

}
