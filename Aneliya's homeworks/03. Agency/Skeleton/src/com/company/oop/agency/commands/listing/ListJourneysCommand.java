package com.company.oop.agency.commands.listing;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.utils.ListingHelpers;

import java.util.List;

public class ListJourneysCommand implements Command {

    private final List<Journey> journeys;

    public ListJourneysCommand(AgencyRepository agencyRepository) {
        journeys = agencyRepository.getJourneys();
    }

    public String execute(List<String> parameters) {
        if (journeys.isEmpty()) {
            return "There are no registered journeys.";
        }

        return ListingHelpers.journeysToString(journeys);
    }

}