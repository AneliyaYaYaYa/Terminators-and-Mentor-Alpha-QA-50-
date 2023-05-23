package com.company.oop.agency.commands.creation;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.utils.ParsingHelpers;
import com.company.oop.agency.utils.ValidationHelper;

import java.util.List;

public class CreateTicketCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String TICKET_CREATED_MESSAGE = "Ticket with ID %d was created.";

    private final AgencyRepository agencyRepository;

    private double cost;
    private int journeyId;

    public CreateTicketCommand(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        parseParameters(parameters);

        Journey journey = agencyRepository.findJourneyById(journeyId);
        Ticket ticket = agencyRepository.createTicket(journey, cost);

        return String.format(TICKET_CREATED_MESSAGE, ticket.getId());
    }

    private void parseParameters(List<String> parameters) {
        journeyId = ParsingHelpers.tryParseInteger(parameters.get(0), "journey id");
        cost = ParsingHelpers.tryParseDouble(parameters.get(1), "cost");
    }

}