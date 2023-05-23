package com.company.oop.agency.tests.models.vehicles;

import com.company.oop.agency.models.vehicles.BusImpl;
import com.company.oop.agency.models.vehicles.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Bus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BusTests {

    public static final double PRICE_MIN_VALUE = 0.1;
    public static final int PASSENGER_MIN_VALUE = 10;
    public static final double VALID_BUS_PRICE = PRICE_MIN_VALUE + 1;
    public static final int VALID_BUS_PASSENGER_CAPACITY = PASSENGER_MIN_VALUE + 1;

    @Test
    public void constructor_Should_Throw_When_PassengerCapacityOutOfBounds() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BusImpl(
                        1,
                        -1,
                        VALID_BUS_PRICE));
    }

    @Test
    public void constructor_Should_Throw_When_PricePerKmLessThanMinimum() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BusImpl(
                        1,
                        VALID_BUS_PASSENGER_CAPACITY,
                        -1));
    }

    @Test
    public void should_Create_Bus_When_ValidValuesArePassed() {
        // Arrange
        Bus bus = new BusImpl(
                1,
                VALID_BUS_PASSENGER_CAPACITY,
                VALID_BUS_PRICE
        );

        // Act, Assert
        assertAll(
                () -> assertEquals(1, bus.getId()),
                () -> assertEquals(VALID_BUS_PASSENGER_CAPACITY, bus.getPassengerCapacity()),
                () -> assertEquals(VALID_BUS_PRICE, bus.getPricePerKilometer()),
                () -> assertEquals(VehicleType.LAND, bus.getType())
        );
    }

}
