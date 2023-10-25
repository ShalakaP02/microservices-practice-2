package com.shalaka.paymentservice.controller;

import com.shalaka.paymentservice.entity.Payment;
import com.shalaka.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        return paymentService.savePayment(payment);
    }

    @GetMapping("/{orderID}")
    public Payment findPaymentHistoryByOrderID(@PathVariable int orderID){
        return  paymentService.findPaymentHistoryByOrderID(orderID);
    }
}
