package com.strippayments.strippayments.service.impl;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentMethodCreateParams;
import com.strippayments.strippayments.dto.PaymentInfo;
import com.strippayments.strippayments.service.CheckoutSerivce;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckoutServiceImpl implements CheckoutSerivce {

    @Value("${stripe-secret-key}")
    private String secretKey;

    @Override
    public PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException {

        Stripe.apiKey = secretKey;

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(paymentInfo.getAmount())
                .setCurrency(paymentInfo.getCurrency())
                .setDescription("Acquisto articolo 100000")
                .setAutomaticPaymentMethods(PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                        .setEnabled(true).build())
                .setReceiptEmail(paymentInfo.getReceiptEmail())
                .build();

        return PaymentIntent.create(params);
    }
}
