package com.codecool.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RestController
public class PageController {

    @Autowired
    StockAPIService service;

    @RequestMapping("/home")
    public String index() {
        try {
            return "Hello trader!" + service.getPrice("aapl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
