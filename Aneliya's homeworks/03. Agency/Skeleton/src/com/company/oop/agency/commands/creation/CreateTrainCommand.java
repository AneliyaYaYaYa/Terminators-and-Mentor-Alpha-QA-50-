package com.company.oop.agency.commands.creation;

import com.company.oop.agency.commands.CommandsConstants;
import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ParsingHelpers;
import com.company.oop.agency.utils.ValidationHelper;

import java.util.List;

public class CreateTrainCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;

    private final AgencyRepository agencyRepository;

    private int cartsCount;
    private int passengerCapacity;
    private double pricePerKilometer;

    public CreateTrainCommand(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public String execute(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        parseParameters(parameters);

        Train createdTrain = agencyRepository.createTrain(passengerCapacity, pricePerKilometer, cartsCount);

        return String.format(CommandsConstants.VEHICLE_CREATED_MESSAGE, createdTrain.getId());
    }

    private void parseParameters(List<String> parameters) {
        passengerCapacity = ParsingHelpers.tryParseInteger(parameters.get(0), "passenger capacity");
        pricePerKilometer = ParsingHelpers.tryParseDouble(parameters.get(1), "price");
        cartsCount = ParsingHelpers.tryParseInteger(parameters.get(2), "carts");
    }

}