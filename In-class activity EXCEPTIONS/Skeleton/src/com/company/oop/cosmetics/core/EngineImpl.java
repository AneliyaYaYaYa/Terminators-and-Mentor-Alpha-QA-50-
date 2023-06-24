package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.core.contracts.CommandFactory;
import com.company.oop.cosmetics.core.contracts.Engine;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class EngineImpl implements Engine {

    private static final String TERMINATION_COMMAND = "Exit";
    private static final String EMPTY_COMMAND_ERROR = "Command cannot be empty.";

    private final CommandFactory commandFactory;
    private final ProductRepository productRepository;

    public EngineImpl() {
        this.commandFactory = new CommandFactoryImpl();
        this.productRepository = new ProductRepositoryImpl();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String inputLine = scanner.nextLine();
                if (inputLine.isBlank()) {
                    System.out.println(EMPTY_COMMAND_ERROR);
                    continue;
                }
                if (inputLine.equalsIgnoreCase(TERMINATION_COMMAND)) {
                    break;
                }
                processCommand(inputLine);
            } catch (Exception ex) {
                if (ex.getMessage() != null && !ex.getMessage().isEmpty()) {
                    System.out.println(ex.getMessage());
                } else {
                    System.out.println(ex);
                }
            }
        }
    }

    private void processCommand(String inputLine) {
        String commandName = extractCommandName(inputLine);
        Command command = commandFactory.createCommandFromCommandName(commandName, productRepository);
        List<String> parameters = extractCommandParameters(inputLine);
        String executionResult = command.execute(parameters);
        System.out.println(executionResult);
    }

    /**
     * Receives a full line and extracts the command to be executed from it.
     * For example, if the input line is "FilterBy Assignee John", the method will return "FilterBy".
     *
     * @param inputLine A complete input line
     * @return The name of the command to be executed
     */
    private String extractCommandName(String inputLine) {
        return inputLine.split(" ")[0];
    }

    /**
     * Receives a full line and extracts the parameters that are needed for the command to execute.
     * For example, if the input line is "FilterBy Assignee John",
     * the method will return a list of ["Assignee", "John"].
     *
     * @param inputLine A complete input line
     * @return A list of the parameters needed to execute the command
     */
    private List<String> extractCommandParameters(String inputLine) {
        String[] commandParts = inputLine.split(" ");
        List<String> parameters = new ArrayList<>();
        for (int i = 1; i < commandParts.length; i++) {
            parameters.add(commandParts[i]);
        }
        return parameters;
    }
}
