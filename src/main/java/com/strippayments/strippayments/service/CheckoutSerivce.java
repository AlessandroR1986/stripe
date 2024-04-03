package com.strippayments.strippayments.service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.strippayments.strippayments.dto.PaymentInfo;
import org.springframework.stereotype.Service;

@Service
public interface CheckoutSerivce {

    PaymentIntent createPaymentIntent(PaymentInfo  paymentInfo) throws StripeException;
}
