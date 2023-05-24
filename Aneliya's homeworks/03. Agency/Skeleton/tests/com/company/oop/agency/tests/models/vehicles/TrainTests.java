package com.company.oop.agency.tests.models.vehicles;

import com.company.oop.agency.models.vehicles.TrainImpl;
import com.company.oop.agency.models.vehicles.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Train;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainTests {

    public static final int CARTS_MIN_VALUE = 1;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int VALID_CARTS = CARTS_MIN_VALUE + 1;
    public static final double VALID_TRAIN_PRICE = PRICE_MIN_VALUE + 1;
    public static final int VALID_TRAIN_PASSENGER_CAPACITY = PASSENGER_MIN_VALUE + 1;

    @Test
    public void constructor_Should_Throw_When_PassengerCapacityOutOfBounds() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TrainImpl(
                        1,
                        -1,
                        VALID_TRAIN_PRICE,
                        VALID_CARTS));
    }

    @Test
    public void constructor_Should_Throw_When_PricePerKmLessThanMinimum() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TrainImpl(
                        1,
                        VALID_TRAIN_PASSENGER_CAPACITY,
                        -1,
                        VALID_CARTS));
    }

    @Test
    public void constructor_Should_Throw_When_CartsLessThanMinValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TrainImpl(
                        1,
                        VALID_TRAIN_PASSENGER_CAPACITY,
                        VALID_TRAIN_PRICE,
                        -1));
    }

    @Test
    public void should_Create_Train_When_ValidValuesArePassed() {
        // Arrange
        Train train = new TrainImpl(
                1,
                VALID_TRAIN_PASSENGER_CAPACITY,
                VALID_TRAIN_PRICE,
                VALID_CARTS
        );

        // Act, Assert
        assertAll(
                () -> assertEquals(1, train.getId()),
                () -> assertEquals(VALID_TRAIN_PASSENGER_CAPACITY, train.getPassengerCapacity()),
                () -> assertEquals(VALID_TRAIN_PRICE, train.getPricePerKilometer()),
                () -> assertEquals(VALID_CARTS, train.getCarts()),
                () -> assertEquals(VehicleType.LAND, train.getType())
        );
    }

}
