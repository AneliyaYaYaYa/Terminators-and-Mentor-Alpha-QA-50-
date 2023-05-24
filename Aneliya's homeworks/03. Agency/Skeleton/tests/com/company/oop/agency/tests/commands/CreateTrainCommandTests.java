package com.company.oop.agency.tests.commands;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.commands.creation.CreateTrainCommand;
import com.company.oop.agency.core.AgencyRepositoryImpl;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.tests.models.vehicles.TrainTests;
import com.company.oop.agency.tests.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * CreateTrainCommand params: {{Passenger Capacity}} {{Price Per Kilometer}} {{Carts}}
 */
public class CreateTrainCommandTests {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;

    private Command command;
    private AgencyRepository repository;

    @BeforeEach
    public void before() {
        this.repository = new AgencyRepositoryImpl();
        this.command = new CreateTrainCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        // Arrange
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        // Act, Assert
        assertThrows(IllegalArgumentException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_PassengerCapacityNotNumber() {
        // Arrange
        List<String> params = List.of("invalid", String.valueOf(TrainTests.VALID_TRAIN_PRICE), String.valueOf(TrainTests.VALID_CARTS));

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_PricePerKmNotNumber() {
        // Arrange
        List<String> params = List.of(
                String.valueOf(TrainTests.VALID_TRAIN_PASSENGER_CAPACITY),
                "invalid",
                String.valueOf(TrainTests.VALID_CARTS));

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_CartsNotNumber() {
        // Arrange
        List<String> params = List.of(
                String.valueOf(TrainTests.VALID_TRAIN_PASSENGER_CAPACITY),
                "2.50",
                "invalid");

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_AddNewTrain_When_PassedValidInput() {
        // Arrange
        List<String> params = List.of(
                String.valueOf(TrainTests.VALID_TRAIN_PASSENGER_CAPACITY),
                String.valueOf(TrainTests.VALID_TRAIN_PRICE),
                String.valueOf(TrainTests.VALID_CARTS));

        // Act
        command.execute(params);
        
        // Assert
        Assertions.assertEquals(1, repository.getVehicles().size());
    }

}
