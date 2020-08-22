package com.codecool.stockApp;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// TODO
class TraderTest {


    @Test // Bid was lower than price, buy should return false.
    void testBidLowerThanPrice() throws IOException {
        Trader trader = Trader.getInstance();
        StockAPIService service = mock(StockAPIService.class);
        try {
            when(service.getPrice("aapl")).thenReturn(300.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        trader.setService(service);
        assertFalse(trader.buy("aapl", 100));
    }

    @Test // bid was equal or higher than price, buy() should return true.
    void testBidHigherThanPrice() {
        Trader trader = Trader.getInstance();
        StockAPIService service = mock(StockAPIService.class);
        try {
            when(service.getPrice("aapl")).thenReturn(100.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        trader.setService(service);
        try {
            assertTrue(trader.buy("aapl", 100));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}