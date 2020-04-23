package com.inti.formation.shop.api.repository.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author Antoine Bertin, Marion Gloriant
 */

// Exemple: idStock = 5, quantite= 68, magasin = « MAG1", active= true,
// idproduct = 1, date = "2020-05-08T01:01:00.001+01:00" 
//(format: yyyy-MM-dd'T'HH:mm:ss.SSSZZZZ) 


@Data
@Document(collection = "Stock")

public class Stock implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long idStock;
	private int qte; 
	private String magasin;
	private boolean active;
	private long idProduct;
	@DateTimeFormat(pattern= "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	public Date date; // note : L'import java.util.Date ne se fait pas lorsque la classe est "private" Oo
	
}



