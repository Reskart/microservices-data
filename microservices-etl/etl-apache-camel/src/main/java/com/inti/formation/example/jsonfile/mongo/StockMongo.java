package com.inti.formation.example.jsonfile.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(collection= "newstock")

public class StockMongo {
	
	@Id
	private Long idStock;
	private Long qte; 
	private String magasin;
	private Boolean active;
	private Long idProduct;
	@DateTimeFormat(pattern= "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	public Date date;
	public String dateSuppression;

}
