package com.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableElasticsearchRepositories
@ComponentScan
public class MicroserviceConsumerStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerStockApplication.class, args);
	}

}
