package com.olaki.BusTicket.repo;

import com.olaki.BusTicket.model.TicketDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TicketRepository {

    private Map<String, TicketDetails> ticketMap;

    public TicketRepository() {
        ticketMap = new HashMap<>();
    }

    public void saveTicket(TicketDetails ticketDetails) {
        String ticketNumber = generateTicketNumber();
        ticketDetails.setTicketNumber(ticketNumber);
        ticketMap.put(ticketNumber, ticketDetails);
    }

    public List<TicketDetails> getAllBookedTickets() {
        return new ArrayList<>(ticketMap.values());
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
