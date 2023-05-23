package com.company.oop.agency.tests.models;

import com.company.oop.agency.models.JourneyImpl;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.tests.models.vehicles.AirplaneTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JourneyTests {

    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int VALID_DISTANCE = DISTANCE_MIN_VALUE + 1;
    public static final String VALID_DESTINATION_NAME = "x".repeat(DESTINATION_MIN_LENGTH + 1);
    public static final String VALID_START_LOCATION_NAME = "x".repeat(START_LOCATION_MIN_LENGTH + 1);

    private Vehicle testVehicle;

    @BeforeEach
    public void before() {
        testVehicle = AirplaneTests.initializeVehicle();
    }

    @Test
    public void constructor_Should_Throw_When_StartLocationLengthOutOfBounds() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new JourneyImpl(
                        1,
                        "x".repeat(DESTINATION_MIN_LENGTH - 1),
                        VALID_DESTINATION_NAME,
                        VALID_DISTANCE,
                        testVehicle));
    }

    @Test
    public void constructor_Should_Throw_When_DestinationLengthOutOfBounds() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new JourneyImpl(
                        1,
                        VALID_START_LOCATION_NAME,
                        "x".repeat(START_LOCATION_MIN_LENGTH - 1),
                        VALID_DISTANCE,
                        testVehicle));
    }

    @Test
    public void constructor_Should_Throw_When_DistanceOutOfBounds() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new JourneyImpl(
                        1,
                        VALID_START_LOCATION_NAME,
                        VALID_DESTINATION_NAME,
                        -1,
                        testVehicle));
    }

    @Test
    public void should_Create_Journey_When_ValidValuesArePassed() {
        // Arrange
        Journey journey = new JourneyImpl(
                1,
                VALID_START_LOCATION_NAME,
                VALID_DESTINATION_NAME,
                VALID_DISTANCE,
                testVehicle
        );

        // Act, Assert
        assertAll(
                () -> assertEquals(1, journey.getId()),
                () -> assertEquals(VALID_START_LOCATION_NAME, journey.getStartLocation()),
                () -> assertEquals(VALID_DESTINATION_NAME, journey.getDestination()),
                () -> assertEquals(VALID_DISTANCE, journey.getDistance()),
                () -> assertSame(testVehicle, journey.getVehicle())
        );
    }

    public static Journey initializeJourney() {
        return new JourneyImpl(
                1,
                VALID_START_LOCATION_NAME,
                VALID_DESTINATION_NAME,
                VALID_DISTANCE,
                AirplaneTests.initializeVehicle()
        );
    }
}
