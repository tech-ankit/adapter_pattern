package com.adapter.service;

import com.adapter.adaper.PaymentAdapter;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void processPayment(long orderId , int amount,String gateway){
        PaymentAdapter paymentGateway = getPaymentGateway(gateway);
        paymentGateway.makePayment(orderId,amount);
    }

    private PaymentAdapter getPaymentGateway(String gateway){
        PaymentAdapter paymentAdapter = null;
        switch (gateway.toLowerCase()){
            case "gpay":
                paymentAdapter = new GPayService();
                break;
            case "paytym":
                paymentAdapter = new PaytymService();
                break;
            case "phonepay":
                paymentAdapter = new PhonePayService();
                break;
            case "bajajfinance":
                paymentAdapter = new BajajFinance();
                break;
        }
        return paymentAdapter;
    }
}
