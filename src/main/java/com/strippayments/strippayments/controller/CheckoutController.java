package com.strippayments.strippayments.controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.strippayments.strippayments.model.CustomerData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CheckoutController {


    @Value("${stripe-secret-key}")
    private String secretKey;

    @RequestMapping("/createCustomer")
    public ResponseEntity<CustomerData> checkout(@RequestBody CustomerData customerData) throws  StripeException {
        Stripe.apiKey = secretKey;
        Map<String, Object> customerParams = new HashMap<>();
        customerParams.put("email", customerData.getEmail());
        customerParams.put("name", customerData.getName());
        Customer customer = Customer.create(customerParams);
        customerData.setId(customer.getId());
        return ResponseEntity.ok(customerData);
    }
}
