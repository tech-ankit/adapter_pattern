package com.adapter.controller;

import com.adapter.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public void makePayment(
            @RequestParam(value = "orderId",defaultValue = "1001") long orderId,
            @RequestParam(value = "amount",defaultValue = "5000") int amount,
            @RequestParam(value = "gateway", defaultValue = "paytym")String gateway
    ){
        paymentService.processPayment(orderId,amount,gateway);
    }
}
