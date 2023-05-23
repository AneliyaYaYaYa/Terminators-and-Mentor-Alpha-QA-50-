package com.company.oop.agency.core;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.commands.creation.*;
import com.company.oop.agency.commands.enums.CommandType;
import com.company.oop.agency.commands.listing.ListJourneysCommand;
import com.company.oop.agency.commands.listing.ListTicketsCommand;
import com.company.oop.agency.commands.listing.ListVehiclesCommand;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.core.contracts.CommandFactory;
import com.company.oop.agency.utils.ParsingHelpers;

public class CommandFactoryImpl implements CommandFactory {

    private static final String INVALID_COMMAND = "Invalid command name: %s!";

    public Command createCommandFromCommandName(String commandName, AgencyRepository agencyRepository) {
        CommandType commandType = ParsingHelpers.tryParseEnum(commandName, CommandType.class, String.format(INVALID_COMMAND, commandName));

        switch (commandType) {
            case CREATEBUS:
                return new CreateBusCommand(agencyRepository);
            case CREATEJOURNEY:
                return new CreateJourneyCommand(agencyRepository);
            case CREATETRAIN:
                return new CreateTrainCommand(agencyRepository);
            case CREATEAIRPLANE:
                return new CreateAirplaneCommand(agencyRepository);
            case CREATETICKET:
                return new CreateTicketCommand(agencyRepository);
            case LISTVEHICLES:
                return new ListVehiclesCommand(agencyRepository);
            case LISTJOURNEYS:
                return new ListJourneysCommand(agencyRepository);
            case LISTTICKETS:
                return new ListTicketsCommand(agencyRepository);
            default:
                throw new IllegalArgumentException(String.format(INVALID_COMMAND, commandName));
        }
    }

}