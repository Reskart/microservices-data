package com.inti.formation.example.jsonfile.converter;

import org.springframework.stereotype.Component;

import com.inti.formation.example.jsonfile.businessterm.stock.StockInput;
import com.inti.formation.example.jsonfile.mongo.StockMongo;

@Component
public class ConverterImpl implements Converter {

	@Override
	public StockMongo convert(StockInput stockInput) {
		StockMongo stock = new StockMongo();
		stock.setIdStock(stockInput.getIdProduct());
		stock.setActive(stockInput.getActive());
		stock.setDate(stockInput.getDate());
		stock.setDateSuppression(stockInput.getDateSuppression());
		stock.setIdProduct(stockInput.getIdProduct());
		stock.setMagasin(stockInput.getMagasin());
		stock.setQte(stockInput.getQte());
		return stock;
	}

}
