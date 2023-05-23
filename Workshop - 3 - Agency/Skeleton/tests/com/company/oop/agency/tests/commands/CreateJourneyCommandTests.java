package com.company.oop.agency.tests.commands;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.commands.creation.CreateJourneyCommand;
import com.company.oop.agency.core.AgencyRepositoryImpl;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.tests.models.JourneyTests;
import com.company.oop.agency.tests.models.vehicles.BusTests;
import com.company.oop.agency.tests.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * CreateJourneyCommand params: {{Start Location}} {{Destination}} {{Distance}} {{Vehicle ID}}
 */
public class CreateJourneyCommandTests {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;

    private Command command;
    private AgencyRepository repository;

    @BeforeEach
    public void before() {
        this.repository = new AgencyRepositoryImpl();
        this.command = new CreateJourneyCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        // Arrange
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        // Act, Assert
        assertThrows(IllegalArgumentException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_DistanceNotNumber() {
        // Arrange
        List<String> params = List.of(
                JourneyTests.VALID_START_LOCATION_NAME,
                JourneyTests.VALID_DESTINATION_NAME,
                "invalid",
                "1");

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_VehicleIdNotNumber() {
        // Arrange
        List<String> params = List.of(
                JourneyTests.VALID_START_LOCATION_NAME,
                JourneyTests.VALID_DESTINATION_NAME,
                String.valueOf(JourneyTests.VALID_DISTANCE),
                "invalid");

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_AddNewJourney_When_PassedValidInput() {
        // Arrange
        repository.createBus(BusTests.VALID_BUS_PASSENGER_CAPACITY, BusTests.VALID_BUS_PRICE);
        int journeyVehicleId = 1;
        List<String> params = List.of(
                JourneyTests.VALID_START_LOCATION_NAME,
                JourneyTests.VALID_DESTINATION_NAME,
                String.valueOf(JourneyTests.VALID_DISTANCE),
                String.valueOf(journeyVehicleId));

        // Act
        command.execute(params);

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, repository.getJourneys().size()),
                () -> Assertions.assertEquals(repository.getJourneys().get(0).getVehicle().getId(), journeyVehicleId)
        );
    }

}
