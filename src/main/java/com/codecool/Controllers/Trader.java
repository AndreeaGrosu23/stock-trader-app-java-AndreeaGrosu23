package com.codecool.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Business logic for stock trading
 **/
@Component
public class Trader {

	StockAPIService stockService;

	@Autowired
	public Trader(@Qualifier("priceStock") StockAPIService service) {
		this.stockService = service;
	}

//	public Trader() {
//        this.stockService = new StockAPIService();
//    }

	/** Checks the price of a stock, and buys it if the price is not greater than the bid amount.
	 * 	@return whether any stock was bought */
	public boolean buy(String symbol, double bid) throws IOException {
		double price = stockService.getPrice(symbol);

        boolean result;
		if (price <= bid) {
			result = true;
//			stockService.buy(symbol);
//			Logger.getInstance().log("Purchased " + symbol + " stock at $" + bid + ", since its higher that the current price ($" + price + ")");
		}
		else {
//            Logger.getInstance().log("Bid for " + symbol + " was $" + bid + " but the stock price is $" + price + ", no purchase was made.");
			result = false;
		}
		return result;
	}

}