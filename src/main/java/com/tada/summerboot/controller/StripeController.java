package com.tada.summerboot.controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StripeController {
//    A controller to interact with Stripe API

    @GetMapping(value="/pay/now",produces = { MediaType.APPLICATION_JSON_VALUE })
    public PaymentIntent charge() throws StripeException {

        // this is a test apiKey. Not meant for production
        Stripe.apiKey = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";

        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(1000L)
                        .setCurrency("sgd")
                        .addPaymentMethodType("card")
                        .setReceiptEmail("rosen@example.com")
                        .build();

        return PaymentIntent.create(params);

    }
}
