package com.inti.formation.example.jsonfile.converter;


import com.inti.formation.example.jsonfile.businessterm.stock.StockInput;
import com.inti.formation.example.jsonfile.mongo.StockMongo;

public interface Converter {
	
	StockMongo convert(final StockInput s);

}
