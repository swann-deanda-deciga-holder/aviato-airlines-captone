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
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


@Controller
public class CheckoutController {

    @Value("${STRIPE_API_PKEY}")
    private String stripePublicKey;
    private StripeService paymentsService;

    public CheckoutController(StripeService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @GetMapping("/checkout")
    public String checkout(Model model,
                           @RequestParam String price,
                           @RequestParam String departureTime,
                           @RequestParam String arrivalTime,
                           @RequestParam String arrivalAirport,
                           @RequestParam String airline
                           ) throws ParseException {

        //Number num = NumberFormat.getInstance().parse(price);

        Locale locale = Locale.US;
        Number parsedPrice = NumberFormat.getCurrencyInstance(locale).parse(price);
        Integer priceToUse = parsedPrice.intValue() * 100;

        String sPrice = priceToUse.toString();


        model.addAttribute("amount", priceToUse); // in cents
        model.addAttribute("displayAmount", sPrice); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);
        model.addAttribute("departureTime", departureTime);
        model.addAttribute("arrivalTime", arrivalTime);
        model.addAttribute("arrivalAirport", arrivalAirport);
        model.addAttribute("airline", airline);
        return "checkout";
    }

    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model)
            throws StripeException {

        // 1. Grab all flight data from hidden inputs in paymentStatus.html using @RequestParam
        // 2. Use RequestParam data to build Flight object.
        // 3. Save Flight obj to database

        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "paymentStatus";
    }

//    @ExceptionHandler(StripeException.class)
//    public String handleError(Model model, StripeException ex) {
//        model.addAttribute("error", ex.getMessage());
//        return "paymentStatus";
//    }

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