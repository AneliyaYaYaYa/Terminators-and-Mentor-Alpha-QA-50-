package com.company.oop.agency.commands.listing;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.utils.ListingHelpers;

import java.util.List;

public class ListTicketsCommand implements Command {

    private final List<Ticket> tickets;

    public ListTicketsCommand(AgencyRepository agencyRepository) {
        tickets = agencyRepository.getTickets();
    }

    public String execute(List<String> parameters) {
        if (tickets.isEmpty()) {
            return "There are no registered tickets.";
        }

        return ListingHelpers.ticketsToString(tickets);
    }

}