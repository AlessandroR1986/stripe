package com.strippayments.strippayments.controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.strippayments.strippayments.dto.PaymentInfo;
import com.strippayments.strippayments.model.CustomerData;
import com.strippayments.strippayments.service.CheckoutSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CheckoutController {

    private final CheckoutSerivce checkoutSerivce;
    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException {
        PaymentIntent paymentIntent = checkoutSerivce.createPaymentIntent(paymentInfo);
        String payment = paymentIntent.toJson();
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
