package com.inti.formation.example.jsonfile.businessterm.stock;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class StockInput {
	
	private Long idStock;
	private Long qte; 
	private String magasin;
	private Boolean active;
	private Long idProduct;
	@DateTimeFormat(pattern= "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	public Date date; 
	public String dateSuppression;

}
