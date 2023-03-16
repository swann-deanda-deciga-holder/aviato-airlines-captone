package com.aviato.demo.controllers;

import com.aviato.demo.data.ChargeRequest;
import com.aviato.demo.services.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CheckoutController {

    @Value("${STRIPE_API_PKEY}")
    private String stripePublicKey;
    private StripeService paymentsService;

    public CheckoutController(StripeService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);
        return "checkout";
    }
    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model)
            throws StripeException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "paymentStatus";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "paymentStatus";
    }
}









//@Controller
//public class CheckoutController {
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
//}