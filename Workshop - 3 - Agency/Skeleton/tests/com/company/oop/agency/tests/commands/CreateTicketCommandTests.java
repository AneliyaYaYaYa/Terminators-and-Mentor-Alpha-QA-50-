package com.company.oop.agency.tests.commands;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.commands.creation.CreateTicketCommand;
import com.company.oop.agency.core.AgencyRepositoryImpl;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.tests.models.JourneyTests;
import com.company.oop.agency.tests.models.vehicles.AirplaneTests;
import com.company.oop.agency.tests.models.vehicles.BusTests;
import com.company.oop.agency.tests.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * CreateTicketCommand params: {{Journey ID}} {{Administrative Costs}}
 */
public class CreateTicketCommandTests {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;

    private Command command;
    private AgencyRepository repository;

    @BeforeEach
    public void before() {
        this.repository = new AgencyRepositoryImpl();
        this.command = new CreateTicketCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        // Arrange
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        // Act, Assert
        assertThrows(IllegalArgumentException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_JourneyIndexNotNumber() {
        // Arrange
        List<String> params = List.of("invalid", "2.50");
        repository.createBus(BusTests.VALID_BUS_PASSENGER_CAPACITY, BusTests.VALID_BUS_PRICE);

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_AdministrativeCostsNotNumber() {
        // Arrange
        List<String> params = List.of("1", "invalid");
        repository.createJourney(
                JourneyTests.VALID_START_LOCATION_NAME,
                JourneyTests.VALID_DESTINATION_NAME,
                JourneyTests.VALID_DISTANCE,
                AirplaneTests.initializeVehicle());

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(params));
    }

    @Test
    public void execute_Should_CreateTicket_When_PassedValidInput() {
        // Arrange
        List<String> params = List.of("1", "2.50");
        Journey journeyToCreate = JourneyTests.initializeJourney();
        repository.createJourney(
                JourneyTests.VALID_START_LOCATION_NAME,
                JourneyTests.VALID_DESTINATION_NAME,
                JourneyTests.VALID_DISTANCE,
                AirplaneTests.initializeVehicle());

        // Act
        command.execute(params);
        
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, repository.getTickets().size()),
                () -> Assertions.assertEquals(repository.getJourneys().get(0).getId(), journeyToCreate.getId())
        );
    }

}
