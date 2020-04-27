package com.inti.formation.data.kafka.producer.producer;


import com.inti.formation.shop.api.repository.model.Stock;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class ProducerBuilder {

    @Value("${kafka.topic-name}")
    private String TOPIC;

    @Autowired
    private KafkaTemplate<Long, Stock> kafkaTemplate;

    @Value("${kafka.compression-type}")
    private String compressionType;

    //milliseconds
//    @Scheduled(fixedDelayString = "${schedule-time}")
//    public void scheduleFixedDelayTask() {
//        ProducerRecord<String, Stock> producerRecord = new ProducerRecord<>(TOPIC, event.getIdProduit(),
//                event);
//	    kafkaTemplate.send(producerRecord);
//    }

}
