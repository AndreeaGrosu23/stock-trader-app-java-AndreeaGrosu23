package com.codecool.stockApp;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides a command line interface for stock trading.
 **/
public class TradingApp {

	private static Logger logger;
	private static StockAPIService service;
	private static RemoteURLReader reader;
	private static Trader trader;

	public static void main(String[] args) {

		logger = Logger.getInstance();
		trader = Trader.getInstance();
		service = new StockAPIService();
		reader = new RemoteURLReader();

	    TradingApp app = new TradingApp(logger, service, reader, trader);
	    app.start();
	}

	public TradingApp(Logger logger1, StockAPIService service1, RemoteURLReader reader1, Trader trader1) {
		logger = logger1;
		service = service1;
		reader = reader1;
		trader = trader1;
	}

	public void start() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a stock symbol (for example aapl):");
		String symbol = keyboard.nextLine();
		System.out.println("Enter the maximum price you are willing to pay: ");
		double price;
		try {
			price = keyboard.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Enter a number");
			return;
		}

		try {
			boolean purchased = Trader.getInstance().buy(symbol, price);
			if (purchased) {
				Logger.getInstance().log("Purchased stock!");
			}
			else {
				Logger.getInstance().log("Couldn't buy the stock at that price.");
			}
		} catch (Exception e) {
			Logger.getInstance().log("There was an error while attempting to buy the stock: " + e.getMessage());
		}
	}
}