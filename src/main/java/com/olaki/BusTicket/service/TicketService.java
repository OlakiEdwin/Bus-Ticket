package com.olaki.BusTicket.service;

import com.olaki.BusTicket.model.TicketDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TicketService {

    private Map<String, TicketDetails> ticketMap;

    public TicketService() {
        ticketMap = new HashMap<>();
    }

    public void bookTicket(TicketDetails ticketDetails) {
        String ticketNumber = generateTicketNumber();
        ticketDetails.setTicketNumber(ticketNumber);
        ticketMap.put(ticketNumber, ticketDetails);
    }

    public List<TicketDetails> getAllBookedTickets() {
        return new ArrayList<>(ticketMap.values());
    }

    public TicketDetails getTicketByNumber(String ticketNumber) {
        return ticketMap.get(ticketNumber);
    }

    private String generateTicketNumber() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder ticketNumber = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int randomIndex = (int) (Math.random() * chars.length());
            ticketNumber.append(chars.charAt(randomIndex));
        }

        long timestamp = System.currentTimeMillis();
        ticketNumber.append(timestamp);

        return ticketNumber.toString();
    }
}
