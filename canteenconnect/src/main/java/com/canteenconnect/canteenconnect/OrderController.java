
package com.canteenconnect.canteenconnect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/checkout")
    public String showCheckout() {
        return "checkout";
    }

    @GetMapping("/order-confirmation")
    public String showOrderConfirmation() {
        return "order-confirmation";
    }

    @GetMapping("/my-orders")
    public String showMyOrders() {
        return "my-orders";
    }
}
