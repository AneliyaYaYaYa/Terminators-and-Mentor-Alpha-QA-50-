package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.commands.enums.VehicleCategory;
import com.company.oop.agency.commands.enums.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends VehicleImpl implements Train {

    private static final int PASSENGER_MIN_VALUE = 30;
    private static final int PASSENGER_MAX_VALUE = 150;
    private static final String INVALID_PASSENGER_CAPACITY = String.format
            ("A train cannot have less than %d passengers or more than %d passengers.",
                    PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    private static final int CARTS_MIN_VALUE = 1;
    private static final int CARTS_MAX_VALUE = 15;
    private static final String INVALID_CART_VALUE = String.format
            ("A train cannot have less than %d cart or more than %d carts.",
                    CARTS_MIN_VALUE, CARTS_MAX_VALUE);
    private static final double PRICE_MIN_VALUE = 0.10;
    private static final double PRICE_MAX_VALUE = 2.50;
    private static final String INVALID_PRICE_PER_KM = String.format
            ("Invalid price per kilometer. Price must be between $%.2f and $%.2f.",
                    PRICE_MIN_VALUE, PRICE_MAX_VALUE);
    private static final String PASSENGER_CAPACITY_NEGATIVE_ERROR = "Passenger capacity cannot be negative";
    private static final String PRICE_PER_KILOMETER_NEGATIVE_ERROR = "Price per kilometer cannot be negative";
    private static final String CARTS_CANNOT_BE_NEGATIVE = "Carts cannot be negative";


    private int passengerCapacity;
    private double pricePerKilometer;
    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        setCarts(carts);

    }

    @Override
    public int getCarts() {
        return this.carts;
    }

    @Override
    public int id() {
        return getId();
    }


    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }




    @Override
    public String getAsString() {
        return String.format("%s ----\n" +
                "Passenger capacity: %d\n" +
                "Price per kilometer: %.2f\n" +
                "Vehicle type: %s\n" +
                "Carts amount: %d\n",
                getVehicleCategory(), getPassengerCapacity(), getPricePerKilometer(), getType(), getCarts());
    }


    @Override
    public VehicleType getType() {
        return VehicleType.LAND;
    }

    @Override
    public VehicleCategory getVehicleCategory() {
        return VehicleCategory.TRAIN;
    }


    private void setPassengerCapacity(int value) {
        ValidationHelper.validatePassengerCapacity(
                value, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, INVALID_PASSENGER_CAPACITY);
        ValidationHelper.againstNull(value, PASSENGER_CAPACITY_NEGATIVE_ERROR);
        this.passengerCapacity = value;
    }

    private void setPricePerKilometer(double value) {
        ValidationHelper.validatePricePerKilometers(value, PRICE_MIN_VALUE, PRICE_MAX_VALUE, INVALID_PRICE_PER_KM);
        ValidationHelper.againstNull(value, PRICE_PER_KILOMETER_NEGATIVE_ERROR);
        this.pricePerKilometer = value;
    }

    private void setCarts(int value) {
        ValidationHelper.validateCarts(value, CARTS_MIN_VALUE, CARTS_MAX_VALUE, INVALID_CART_VALUE);
        ValidationHelper.againstNull(value, CARTS_CANNOT_BE_NEGATIVE);
        this.carts = value;
    }
}