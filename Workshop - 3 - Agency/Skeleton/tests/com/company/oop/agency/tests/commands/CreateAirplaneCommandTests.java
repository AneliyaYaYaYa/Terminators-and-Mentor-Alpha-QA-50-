package com.company.oop.agency.tests.commands;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.commands.creation.CreateAirplaneCommand;
import com.company.oop.agency.core.AgencyRepositoryImpl;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.tests.models.vehicles.AirplaneTests;
import com.company.oop.agency.tests.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * CreateAirplaneCommand params: {{Passenger Capacity}} {{Price Per Kilometer}} {{Has Free Food}}
 */
public class CreateAirplaneCommandTests {

    public static final int EXPECTED_NUMBER_OF_params = 3;

    private Command command;
    private AgencyRepository repository;

    @BeforeEach
    public void before() {
        this.repository = new AgencyRepositoryImpl();
        this.command = new CreateAirplaneCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        // Arrange
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_params - 1);

        // Act, Assert
        assertThrows(IllegalArgumentException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_PassengerCapacityNotNumber() {
        // Arrange
        List<String> params = List.of(
                "invalid",
                String.valueOf(AirplaneTests.VALID_AIRPLANE_PRICE),
                "true");

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_PricePerKmNotNumber() {
        // Arrange
        List<String> params = List.of(
                String.valueOf(AirplaneTests.VALID_AIRPLANE_PASSENGER_CAPACITY),
                "invalid",
                "true");

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_HasFreeFoodNotBoolean() {
        // Arrange
        List<String> params = List.of(
                String.valueOf(AirplaneTests.VALID_AIRPLANE_PASSENGER_CAPACITY),
                String.valueOf(AirplaneTests.VALID_AIRPLANE_PRICE),
                "invalid");

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_AddNewAirplane_When_PassedValidInput() {
        // Arrange
        List<String> params = List.of(
                String.valueOf(AirplaneTests.VALID_AIRPLANE_PASSENGER_CAPACITY),
                String.valueOf(AirplaneTests.VALID_AIRPLANE_PRICE),
                "true");

        // Act
        command.execute(params);

        // Assert
        Assertions.assertEquals(1, repository.getVehicles().size());
    }

}
