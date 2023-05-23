package com.company.oop.agency.tests.models.vehicles;

import com.company.oop.agency.models.vehicles.AirplaneImpl;
import com.company.oop.agency.models.vehicles.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirplaneTests {

    public static final double PRICE_MIN_VALUE = 0.1;
    public static final int PASSENGER_MIN_VALUE = 1;
    public static final double VALID_AIRPLANE_PRICE = PRICE_MIN_VALUE + 1;
    public static final int VALID_AIRPLANE_PASSENGER_CAPACITY = PASSENGER_MIN_VALUE + 1;

    @Test
    public void constructor_Should_ThrowException_When_PassengerCapacityOutOfBounds() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new AirplaneImpl(
                        1,
                        -1,
                        VALID_AIRPLANE_PRICE,
                        true));
    }

    @Test
    public void constructor_Should_ThrowException_When_PricePerKmOutOfBounds() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new AirplaneImpl(
                        1,
                        VALID_AIRPLANE_PASSENGER_CAPACITY,
                        -1,
                        true));
    }

    @Test
    public void should_Create_Airplane_When_ValidValuesArePassed() {
        // Arrange
        Airplane airplane = new AirplaneImpl(
                1,
                VALID_AIRPLANE_PASSENGER_CAPACITY,
                VALID_AIRPLANE_PRICE,
                true
        );

        // Act, Assert
        assertAll(
                () -> assertEquals(1, airplane.getId()),
                () -> assertEquals(VALID_AIRPLANE_PASSENGER_CAPACITY, airplane.getPassengerCapacity()),
                () -> assertEquals(VALID_AIRPLANE_PRICE, airplane.getPricePerKilometer()),
                () -> assertTrue(airplane.hasFreeFood()),
                () -> assertEquals(VehicleType.AIR, airplane.getType())
        );
    }

    public static Vehicle initializeVehicle() {
        return new AirplaneImpl(
                1,
                VALID_AIRPLANE_PASSENGER_CAPACITY,
                VALID_AIRPLANE_PRICE,
                true);
    }

}
