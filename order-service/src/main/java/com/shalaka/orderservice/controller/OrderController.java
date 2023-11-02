package com.shalaka.orderservice.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shalaka.orderservice.common.Payment;
import com.shalaka.orderservice.common.TransactionRequest;
import com.shalaka.orderservice.common.TransactionResponse;
import com.shalaka.orderservice.entity.Order;
import com.shalaka.orderservice.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    Logger log = LoggerFactory.getLogger(OrderController.class);

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest) throws JsonProcessingException {
        log.info("OrderController bookOrder request {} ",new ObjectMapper().writeValueAsString(transactionRequest));
        TransactionResponse response = orderService.saveOrder(transactionRequest);
        log.info("OrderController bookOrder response {} ",new ObjectMapper().writeValueAsString(response));
        return response;
    }

    @GetMapping("/getOrder")
    public List<Order> getOrder() throws JsonProcessingException {
        log.info("OrderController getOrder request");
        List<Order> orderList =  orderService.getOrders();
        log.info("OrderController getOrder response {}",new ObjectMapper().writeValueAsString(orderList));
        return orderList;
    }
}
