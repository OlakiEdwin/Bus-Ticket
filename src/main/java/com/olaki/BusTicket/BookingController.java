package com.olaki.BusTicket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {

    @GetMapping("/bookticket.html")
    public String showBookTicketPage() {
        return "bookticket";
    }
}
