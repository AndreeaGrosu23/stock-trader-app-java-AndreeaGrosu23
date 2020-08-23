//package com.codecool.Controllers;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//// TODO
//class StockAPIServiceTest {
//
//    @Test // everything works
//    void testGetPriceNormalValues() {
//
//        StockAPIService service = new StockAPIService();
//
//        // We make a mock of the RemoteURLReader class.
//        RemoteURLReader reader = mock(RemoteURLReader.class);
//
//        // We define mock behaviours: In this case when the "readFromUrl" method is called on the mock, it will return "{
//        //  "symbol" : "AAPL",
//        //  "price" : 338.85
//        //}"
//
//        try {
//            when(reader.readFromUrl("https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980?stock=aapl")).thenReturn("{'symbol':'AAPL', 'price':338.85}");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // We use the newly created mock class when we want to test the StockAPIService class
//
//        service.setReader(reader);
//
//        try {
//            assertEquals(338.85, service.getPrice("aapl"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test // readFromURL threw an exception
//    void testGetPriceServerDown() {
//        RemoteURLReader reader = new RemoteURLReader();
//        boolean thrown = false;
//
//        try {
//            reader.readFromUrl("https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980?stock=blabla");
//        } catch (Exception e) {
//            thrown = true;
//        }
//
//        assertTrue(thrown);
//    }
//
//    @Test // readFromURL returned wrong JSON
//    void testGetPriceMalformedResponse() {
//
//    }
//
//}