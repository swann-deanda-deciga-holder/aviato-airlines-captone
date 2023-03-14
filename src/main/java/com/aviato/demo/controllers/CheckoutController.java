package com.aviato.demo.controllers;

import com.aviato.demo.models.Flight;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CheckoutController {
//    @PostMapping("/create/checkout/session")
//    public String checkout() throws StripeException {
//        String YOUR_DOMAIN = "http://localhost:4242";
//        SessionCreateParams params =
//                SessionCreateParams.builder()
//                        .setMode(SessionCreateParams.Mode.PAYMENT)
//                        .setSuccessUrl(YOUR_DOMAIN + "http://localhost:8080/success.html")
//                        .setCancelUrl(YOUR_DOMAIN + "http://localhost:8080/cancel.html")
//                        .addLineItem(
//                                SessionCreateParams.LineItem.builder()
//                                        .setQuantity(1L)
//                                        // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
//                                        .setPrice("4")
//                                        .build())
//                        .build();
//        Session session = Session.create(params);
//        return "checkout";
//    }

    @PostMapping("/create/checkout/session")
    public String checkout(@RequestParam("seats") int numSeats) throws StripeException {
        String YOUR_DOMAIN = "http://localhost:4242";
        Flight flight = new Flight();
        int remainingSeats = flight.getSeat() - numSeats;
        flight.updateSeats(numSeats);
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(YOUR_DOMAIN + "/success.html")
                        .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
                        .addLineItem(
                                SessionCreateParams.LineItem.builder()
                                        .setQuantity((long) numSeats)
                                        .setPrice("4")
                                        .build())
                        .build();
        Session session = Session.create(params);
        return "checkout";
    }

}