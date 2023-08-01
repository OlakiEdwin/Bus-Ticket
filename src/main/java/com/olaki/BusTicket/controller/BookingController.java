package com.olaki.BusTicket.controller;

import com.olaki.BusTicket.model.TicketDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @GetMapping("/bookTicket")
    public String showBookTicketPage(Model model) {
        model.addAttribute("ticketDetails", new TicketDetails());
        return "bookTicket";
    }

    @PostMapping("/bookTicket")
    public String bookTicket(@ModelAttribute TicketDetails ticketDetails, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("ticketDetails", ticketDetails);
        return "redirect:/booking/ticketDetails";
    }

    @GetMapping("/ticketDetails")
    public String showTicketDetails(@ModelAttribute("ticketDetails") TicketDetails ticketDetails, Model model) {
        model.addAttribute("ticketDetails", ticketDetails);
        return "ticketDetails";
    }
}

