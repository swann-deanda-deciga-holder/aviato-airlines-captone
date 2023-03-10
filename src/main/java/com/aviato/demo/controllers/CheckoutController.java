package com.aviato.demo.controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CheckoutController {
    @PostMapping("/create/checkout/session")
    public String checkout() throws StripeException {
        String YOUR_DOMAIN = "http://localhost:4242";
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(YOUR_DOMAIN + "http://localhost:8080/success.html")
                        .setCancelUrl(YOUR_DOMAIN + "http://localhost:8080/cancel.html")
                        .addLineItem(
                                SessionCreateParams.LineItem.builder()
                                        .setQuantity(1L)
                                        // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
                                        .setPrice("4")
                                        .build())
                        .build();
        Session session = Session.create(params);
        return "checkout.html";
    }
}