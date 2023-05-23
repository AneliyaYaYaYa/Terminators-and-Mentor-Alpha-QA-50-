package com.company.oop.agency.core.contracts;

import com.company.oop.agency.commands.contracts.Command;

public interface CommandFactory {

    Command createCommandFromCommandName(String commandTypeAsString, AgencyRepository agencyRepository);

}