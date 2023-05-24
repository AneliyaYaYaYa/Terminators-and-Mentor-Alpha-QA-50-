package com.company.oop.agency.tests.core;

import com.company.oop.agency.core.AgencyRepositoryImpl;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.exceptions.ElementNotFoundException;
import com.company.oop.agency.models.TicketImpl;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.tests.models.JourneyTests;
import com.company.oop.agency.tests.models.vehicles.AirplaneTests;
import com.company.oop.agency.tests.models.vehicles.BusTests;
import com.company.oop.agency.tests.models.vehicles.TrainTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AgencyRepositoryTests {

    AgencyRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository = new AgencyRepositoryImpl();
    }

    @Test
    public void constructor_Should_InitializeAllCollections() {
        // Arrange, Act, Assert
        Assertions.assertAll(
                () -> Assertions.assertNotNull(repository.getVehicles()),
                () -> Assertions.assertNotNull(repository.getJourneys()),
                () -> Assertions.assertNotNull(repository.getTickets())
        );
    }

    @Test
    public void getVehicles_Should_ReturnCopyOfCollection() {
        // Arrange
        List<Vehicle> categoriesReference = repository.getVehicles();
        List<Vehicle> sameReference = repository.getVehicles();

        // Act, Assert
        Assertions.assertNotSame(categoriesReference, sameReference);
    }

    @Test
    public void getJourneys_Should_ReturnCopyOfCollection() {
        // Arrange
        repository.createJourney(
                JourneyTests.VALID_START_LOCATION_NAME,
                JourneyTests.VALID_DESTINATION_NAME,
                JourneyTests.VALID_DISTANCE,
                AirplaneTests.initializeVehicle()
        );
        repository.getJourneys().clear();

        // Act, Assert
        Assertions.assertEquals(1, repository.getJourneys().size());
    }

    @Test
    public void getTickets_Should_ReturnCopyOfCollection() {
        // Arrange
        List<Ticket> ticketList = repository.getTickets();
        ticketList.add(new TicketImpl(
                1,
                JourneyTests.initializeJourney(),
                2.5
        ));

        // Act, Assert
        Assertions.assertNotEquals(ticketList.size(), repository.getTickets().size());
    }

    @Test
    public void findVehicleById_Should_ThrowException_When_VehicleDoesNotExist() {
        //Arrange, Act, Assert
        assertThrows(ElementNotFoundException.class, () -> repository.findVehicleById(1));
    }

    @Test
    public void findVehicleById_Should_ReturnVehicle_When_VehicleExists() {
        //Arrange
        repository.createAirplane(
                AirplaneTests.VALID_AIRPLANE_PASSENGER_CAPACITY,
                AirplaneTests.VALID_AIRPLANE_PRICE,
                true);

        // Act
        Vehicle vehicle = repository.findVehicleById(1);

        // Assert
        assertAll(
                () -> assertEquals(1, vehicle.getId()),
                () -> Assertions.assertEquals(AirplaneTests.VALID_AIRPLANE_PASSENGER_CAPACITY, vehicle.getPassengerCapacity()),
                () -> Assertions.assertEquals(AirplaneTests.VALID_AIRPLANE_PRICE, vehicle.getPricePerKilometer())
        );
    }

    @Test
    public void findJourneyById_Should_ThrowException_When_JourneyDoesNotExist() {
        //Arrange, Act, Assert
        assertThrows(ElementNotFoundException.class, () -> repository.findJourneyById(1));
    }

    @Test
    public void findJourneyById_Should_ReturnJourney_When_JourneyExists() {
        // Arrange
        Vehicle testVehicle = AirplaneTests.initializeVehicle();
        repository.createJourney(
                JourneyTests.VALID_START_LOCATION_NAME,
                JourneyTests.VALID_DESTINATION_NAME,
                JourneyTests.VALID_DISTANCE,
                testVehicle
        );

        // Act
        Journey journey = repository.findJourneyById(1);

        // Assert
        assertAll(
                () -> assertEquals(1, journey.getId()),
                () -> assertEquals(JourneyTests.VALID_START_LOCATION_NAME, journey.getStartLocation()),
                () -> assertEquals(JourneyTests.VALID_DESTINATION_NAME, journey.getDestination()),
                () -> Assertions.assertEquals(JourneyTests.VALID_DISTANCE, journey.getDistance()),
                () -> assertSame(testVehicle, journey.getVehicle())
        );
    }

    @Test
    public void findTicketById_Should_ThrowException_When_TicketDoesNotExist() {
        //Arrange, Act, Assert
        assertThrows(ElementNotFoundException.class, () -> repository.findTicketById(1));
    }

    @Test
    public void findTicketById_Should_ReturnTicket_When_TicketExists() {
        // Arrange
        Journey testJourney = JourneyTests.initializeJourney();
        repository.createTicket(
                testJourney,
                2.5
        );

        // Act
        Ticket ticket = repository.findTicketById(1);

        // Assert
        assertAll(
                () -> assertEquals(1, ticket.getId()),
                () -> assertSame(testJourney, ticket.getJourney()),
                () -> assertEquals(2.5, ticket.getAdministrativeCosts())
        );
    }

    @Test
    public void createAirplane_Should_AddAirplaneToList() {
        // Arrange
        repository.createAirplane(
                AirplaneTests.VALID_AIRPLANE_PASSENGER_CAPACITY,
                AirplaneTests.VALID_AIRPLANE_PRICE,
                true);

        // Act, Assert
        assertEquals(1, repository.getVehicles().size());
    }

    @Test
    public void createBus_Should_AddBusToList() {
        // Arrange
        repository.createBus(
                BusTests.VALID_BUS_PASSENGER_CAPACITY,
                BusTests.VALID_BUS_PRICE
        );

        // Act, Assert
        assertEquals(1, repository.getVehicles().size());
    }

    @Test
    public void createTrain_Should_AddTrainToList() {
        // Arrange
        repository.createTrain(
                TrainTests.VALID_TRAIN_PASSENGER_CAPACITY,
                TrainTests.VALID_TRAIN_PRICE,
                TrainTests.VALID_CARTS);

        // Act, Assert
        assertEquals(1, repository.getVehicles().size());
    }

    @Test
    public void createJourney_Should_AddJourneyToList() {
        // Arrange
        repository.createJourney(
                JourneyTests.VALID_START_LOCATION_NAME,
                JourneyTests.VALID_DESTINATION_NAME,
                JourneyTests.VALID_DISTANCE,
                AirplaneTests.initializeVehicle()
        );

        // Act, Assert
        assertEquals(1, repository.getJourneys().size());
    }

    @Test
    public void createTicket_Should_AddTicketToList() {
        // Arrange
        repository.createTicket(
                JourneyTests.initializeJourney(),
                2.5
    );

        // Act, Assert
        assertEquals(1, repository.getTickets().size());
    }
}
