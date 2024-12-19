package com.adapter.service;

import com.adapter.adaper.PaymentAdapter;

public class PaytymService implements PaymentAdapter {
    @Override
    public void makePayment(long orderId, int amount) {
        System.out.println(String.format(
                """
                Payment Successful With Orderd : %s,
                with the Amount of : %s
                Paytym
                """,orderId,amount
        ));
    }
}
