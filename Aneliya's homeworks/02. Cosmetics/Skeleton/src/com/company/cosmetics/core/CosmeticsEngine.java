package com.company.cosmetics.core;


import com.company.cosmetics.core.contracts.*;
import com.company.cosmetics.core.factories.CommandFactoryImpl;
import com.company.cosmetics.core.factories.CosmeticsFactoryImpl;
import com.company.cosmetics.core.providers.CommandParserImpl;
import com.company.cosmetics.core.providers.ConsoleReader;
import com.company.cosmetics.core.providers.ConsoleWriter;

import java.util.List;

public final class CosmeticsEngine implements Engine {
    
    private static final String TERMINATION_COMMAND = "Exit";
    
    private final CosmeticsFactory cosmeticsFactory;
    
    private final CommandParser commandParser;
    private final CommandFactory commandFactory;
    private final Reader reader;
    private final Writer writer;
    private final CosmeticsRepository cosmeticsRepository;
    
    public CosmeticsEngine() {
        cosmeticsFactory = new CosmeticsFactoryImpl();
        commandParser = new CommandParserImpl();
        reader = new ConsoleReader();
        writer = new ConsoleWriter();
        commandFactory = new CommandFactoryImpl();
        cosmeticsRepository = new CosmeticsRepositoryImpl();
        
    }
    
    
    public void start() {
        while (true) {
            try {
                String commandAsString = reader.readLine();
                if (commandAsString.equalsIgnoreCase(TERMINATION_COMMAND)) {
                    break;
                }
                processCommand(commandAsString);
                
            } catch (Exception ex) {
                writer.writeLine(ex.toString());
            }
        }
    }
    
    private void processCommand(String commandAsString) {
        if (commandAsString == null || commandAsString.trim().equals("")) {
            throw new IllegalArgumentException("Command cannot be null or empty.");
        }
        
        String commandName = commandParser.parseCommand(commandAsString);
        Command command = commandFactory.createCommand(commandName, cosmeticsFactory, cosmeticsRepository);
        List<String> parameters = commandParser.parseParameters(commandAsString);
        String executionResult = command.execute(parameters);
        writer.writeLine(executionResult);
        
    }
    
}
