package com.inti.formation.shop.api;

import com.inti.formation.data.kafka.producer.producer.ProducerBuilder;
import com.inti.formation.shop.api.repository.StockRepository;
import com.inti.formation.shop.api.repository.model.Stock;
import com.inti.formation.shop.api.rest.bean.StockRequest;
import com.inti.formation.shop.api.rest.exception.InternalServerException;
import com.inti.formation.shop.api.rest.exception.ValidationParameterException;
import com.inti.formation.shop.api.service.StockService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/shop")
@Slf4j
// Controller , Roote
public class Endpoint {
	

//	ProducerBuilder prod = new ProducerBuilder();
	
	@Value("${kafka.topic-name}")
    private String TOPIC;
	
	@Autowired
	private StockRepository stockRepository;

    @Autowired
    private KafkaTemplate<Long, Stock> kafkaTemplate;

    @Value("${kafka.compression-type}")
    private String compressionType;

    public void sendK(Stock stock) {
        ProducerRecord<Long, Stock> producerRecord = new ProducerRecord<>(TOPIC, stock.getIdStock(), stock);
	    kafkaTemplate.send(producerRecord);
    }
    

    
    public String dayDate() {	
    	DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    return format.format(date);
    }
	
	
	
//    @Autowired
//    CustomerService customerService;
    
    @Autowired
    StockService stockService;

    @ExceptionHandler(ValidationParameterException.class)
    public Mono<ResponseEntity<String>> handlerValidationParameterException(ValidationParameterException e) {
     return Mono.just(
                badRequest().body("Missing parameter: "+ e.getMessage()));
    }

    @ExceptionHandler(InternalServerException.class)
    public Mono<ResponseEntity<String>> handlerInternalServerException() {
        return Mono.just(status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error server has occurred "));
    }


    @PostMapping(value="/add", headers="Accept=application/json; charset=utf-8")
    @ResponseStatus(value=HttpStatus.CREATED, reason="Stock has been registered!")
    public Mono<String> create(@RequestBody StockRequest s){
        return Mono.just(s).map(data->{
            return stockService.add(data).subscribe().toString();
        });
    }
    
    
    @GetMapping
    @RequestMapping(value="/stock")
    public Flux<Stock> findActiveStockSinceDate(@RequestParam(required = true, name = "date") @DateTimeFormat(pattern= "yyyy-MM-dd'T'HH:mm:ss.SSSXXX") Date date){

		return stockService.searchActiveSinceDate(date);
    }
    
    
    @GetMapping
    @RequestMapping(value = "/stocks/")
    public Flux<Stock> getStocks() {
    	log.info("All stocks searching");
    	return stockService.findAll()
    			.switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
    			.map(data -> data);
    }
    
    
    @PutMapping(value = "/update" , headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus( value  = HttpStatus.CREATED, reason="Stock is updated" )
    public Mono<String> updateStock(@RequestBody StockRequest stock){
    	if( ObjectUtils.anyNotNull(stock)  && !ObjectUtils.allNotNull(stock.getDate(), stock.getIdProduct(), stock.getIdStock(), stock.getMagasin(), stock.getQte() )){
            log.error("Validation error: one of attributes is not found");
            return Mono.error(new ValidationParameterException("(Validation error message): one of attributes is not found" ));
        }
		return Mono.just(stock)
				.map(data-> {
					
					return stockService.update( data).subscribe().toString();
				});
    }
    
    @DeleteMapping(value = "/delete", headers = "Accept=application/json; charset=utf-8")
    public Mono<Void> deleteStock(@RequestBody Stock stock){

    	stock.setDateSuppression(dayDate());
    	
//    	prod.sendK(stock);

    	
    	return stockService.delete(stock).doOnNext(data ->
    	sendK(stock));
    	
    	
    }
    
    @DeleteMapping(value="/deleteById")
    public Mono<Void> deleteStockById(@RequestParam(name = "id") Long id){
//    	Stock stock = stockService.findById(id).block();
    	return stockService.deleteById(id).doOnNext(data->
    	sendK(stockService.findById(id).block()));
    }
    
					
//  @PostMapping(value = "/register" , headers = "Accept=application/json; charset=utf-8")
//  @ResponseStatus( value  = HttpStatus.CREATED, reason="Customer is registered" )
//  public Mono<String> create(@RequestBody CustomerRequest customer) {
//      // Vérification des paramètres
//      if( ObjectUtils.anyNotNull(customer)  && !ObjectUtils.allNotNull(customer.getEmail(),customer.getName(), customer.getFirstname() )){
//          log.error("Validation error: one of attributes is not found");
//          return Mono.error(new ValidationParameterException("(Validation error message): one of attributes is not found" ));
//      }
//      return Mono.just(customer)
//      .map(data->
//              {
//
//                  return customerService.register( data).subscribe().toString();
//
//              });
//  }		
    
//  @RequestMapping(value = "/customers{customername}")
//  public Flux<Customer> getCustomers(@RequestParam(required = true, name = "customername") String customername ) {
//      log.info("Searching  {} ",customername );
//      return customerService.searchName(customername)
//
//              // uses of doNext
//
//              .doOnNext(customer -> log.info(customer.getEmail()+ " is found"));
//
//
//  }



//  @GetMapping
//  @RequestMapping(value = "/customers/")
//  public Flux<Customer> getCustomers() {
//      log.info("All customers searching");
//    return customerService.getCustomers()
//            // uses of map
//              .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
//              .map( data-> data);
//  }
    
}

