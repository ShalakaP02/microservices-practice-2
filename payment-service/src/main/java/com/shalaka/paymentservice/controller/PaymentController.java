package com.shalaka.paymentservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shalaka.paymentservice.entity.Payment;
import com.shalaka.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    Logger log = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) throws JsonProcessingException {
        log.info("PaymentController doPayment request {} ",new ObjectMapper().writeValueAsString(payment));
        Payment paymentResp =  paymentService.savePayment(payment);
        log.info("PaymentController doPayment response {} ",new ObjectMapper().writeValueAsString(paymentResp));
        return paymentResp;
    }

    @GetMapping("/{orderID}")
    public Payment findPaymentHistoryByOrderID(@PathVariable int orderID) throws JsonProcessingException {
        log.info("PaymentController findPaymentHistoryByOrderID request {} ",orderID);
        Payment paymentResp = paymentService.findPaymentHistoryByOrderID(orderID);
        log.info("PaymentController findPaymentHistoryByOrderID response {} ",new ObjectMapper().writeValueAsString(paymentResp));
        return  paymentResp;
    }
}
