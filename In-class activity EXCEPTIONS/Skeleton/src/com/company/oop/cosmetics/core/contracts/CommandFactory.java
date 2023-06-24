package com.company.oop.cosmetics.core.contracts;

import com.company.oop.cosmetics.commands.contracts.Command;

public interface CommandFactory {

    Command createCommandFromCommandName(String commandType, ProductRepository productRepository);

}
