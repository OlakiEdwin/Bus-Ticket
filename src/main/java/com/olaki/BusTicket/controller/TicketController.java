package com.olaki.BusTicket.controller;

import com.olaki.BusTicket.model.TicketDetails;
import com.olaki.BusTicket.service.TicketService;
import com.olaki.BusTicket.utils.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/booking")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/bookTicket")
    public String showBookTicketPage(Model model) {
        model.addAttribute("ticketDetails", new TicketDetails());
        return "BookTicket";
    }

    @PostMapping("/bookTicket")
    public String bookTicket(@ModelAttribute TicketDetails ticketDetails, RedirectAttributes redirectAttributes) {
        ticketService.bookTicket(ticketDetails);
        redirectAttributes.addFlashAttribute("ticketDetails", ticketDetails);
        return "redirect:/booking/ticketDetails";
    }

    @GetMapping("/ticketDetails")
    public String showTicketDetails(@ModelAttribute("ticketDetails") TicketDetails ticketDetails, Model model) {
        model.addAttribute("ticketDetails", ticketDetails);
        return "TicketDetails";
    }

    @GetMapping("/ticketDetails/{ticketNumber}/export_pdf")
    public void generatePdfFile(@PathVariable String ticketNumber, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ticket_" + ticketNumber + ".pdf";
        response.setHeader(headerKey, headerValue);

        TicketDetails ticket = ticketService.getTicketByNumber(ticketNumber);
        PdfGenerator generator = new PdfGenerator();
        generator.generate(ticket, response);
    }
}
