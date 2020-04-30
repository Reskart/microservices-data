package com.kafka.consumer.model;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author Antoine Bertin, Marion Gloriant
 */

// Exemple: idStock = 5, quantite= 68, magasin = « MAG1", active= true,
// idproduct = 1, date = "2020-05-08T01:01:00.001+01:00" 
//(format: yyyy-MM-dd'T'HH:mm:ss.SSSZZZZ) 

@Document(indexName="shop", type="stock")
@Data
public class Stock{
	

	@Id
	@Field(type=FieldType.Long)
	private Long idStock;
	@Field(type=FieldType.Integer)
	private int qte;
	@Field(type=FieldType.Text)
	private String magasin;
	@Field(type=FieldType.Boolean)
	private boolean active;
	@Field(type=FieldType.Long)
	private long idProduct;
	@Field(type=FieldType.Date)
	@DateTimeFormat(pattern= "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	public Date date; // note : L'import java.util.Date ne se fait pas lorsque la classe est "private" Oo
	@Field(type=FieldType.Text)
	public String dateSuppression;
}



