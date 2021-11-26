package com.demosocketbackend.controller;

import com.demosocketbackend.model.Product;
import com.demosocketbackend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class WebsocketController {
    @Autowired
    private IProductService productService;

    @MessageMapping("/products")
    @SendTo("/topic/products")
    public Product addProductUsingSocket(Product product){
        return productService.save(product);
    }

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public String sendMessage(String message){
        return message;
    }

    @MessageMapping("/notify")
    @SendTo("/topic/chat")
    public String sendNotify(String notify){
        return notify;
    }
}
