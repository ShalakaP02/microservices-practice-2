package com.shalaka.orderservice.controller;


import com.shalaka.orderservice.common.Payment;
import com.shalaka.orderservice.common.TransactionRequest;
import com.shalaka.orderservice.common.TransactionResponse;
import com.shalaka.orderservice.entity.Order;
import com.shalaka.orderservice.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest){
        return orderService.saveOrder(transactionRequest);
    }

    @GetMapping("/getOrder")
    public List<Order> getOrder(){
        return orderService.getOrders();
    }
}
