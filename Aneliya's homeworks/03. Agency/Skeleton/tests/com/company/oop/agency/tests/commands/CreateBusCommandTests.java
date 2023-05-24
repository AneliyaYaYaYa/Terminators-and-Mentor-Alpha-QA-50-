package com.company.oop.agency.tests.commands;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.commands.creation.CreateBusCommand;
import com.company.oop.agency.core.AgencyRepositoryImpl;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.tests.models.vehicles.BusTests;
import com.company.oop.agency.tests.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * CreateBusCommand arguments: {{Passenger Capacity}} {{Price Per Kilometer}}
 */
public class CreateBusCommandTests {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;

    private Command command;
    private AgencyRepository repository;

    @BeforeEach
    public void before() {
        this.repository = new AgencyRepositoryImpl();
        this.command = new CreateBusCommand(repository);
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
        List<String> params = List.of(
                "invalid",
                String.valueOf(BusTests.VALID_BUS_PRICE));

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_PricePerKmNotNumber() {
        // Arrange
        List<String> params = List.of(
                String.valueOf(BusTests.VALID_BUS_PASSENGER_CAPACITY),
                "invalid");

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_AddNewBus_When_PassedValidInput() {
        // Arrange
        List<String> params = List.of(
                String.valueOf(BusTests.VALID_BUS_PASSENGER_CAPACITY),
                String.valueOf(BusTests.VALID_BUS_PRICE));

        // Act
        command.execute(params);

        // Assert
        Assertions.assertEquals( 1, repository.getVehicles().size());
    }

}
