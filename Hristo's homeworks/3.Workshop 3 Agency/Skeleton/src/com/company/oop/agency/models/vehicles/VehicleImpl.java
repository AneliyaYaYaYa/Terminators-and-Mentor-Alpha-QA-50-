package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.commands.enums.VehicleCategory;
import com.company.oop.agency.commands.enums.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public abstract class VehicleImpl implements Vehicle {
    private static final int MIN_PASSENGER_ERROR = 1;
    private static final int MAX_PASSENGER_ERROR = 800;
    private static final String INVALID_PASSENGER_CAPACITY_ERROR_MESSAGE = String.format
            ("A vehicle with less than $%d passengers or more than $%d passengers cannot exist!",
                    MIN_PASSENGER_ERROR, MAX_PASSENGER_ERROR);
    private static final double MIN_PRICE_ERROR = 0.10;
    private static final double MAX_PRICE_ERROR = 2.50;
    private static final String INVALID_PRICE_PER_KM_ERROR = String.format("A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!", MIN_PRICE_ERROR, MAX_PRICE_ERROR);
    private static final String INVALID_ID = "Id cannot be negative.";
    private static final String VEHICLE_PASSENGER_NULL_ERROR = "A vehicle passengers cannot be negative.";
    private static final String INVALID_NEGATIVE_PRICE_KM = "A vehicle with a price per kilometer cannot be negative";
    private static final String INVALID_VEHICLE_CATEGORY = "Vehicle category cannot be null";
    private static final String INVALID_VEHICLE_TYPE = "Vehicle type cannot be null";
    private int id;
    private int passengerCapacity;
    private double pricePerKilometer;
    private VehicleType type;
    private VehicleCategory category;

    public VehicleImpl(int id, int passengerCapacity, double pricePerKilometer) {
        setId(id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
    }


    public int getId() {
        return this.id;
    }


    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }


    public double getPricePerKilometer() {
        return this.pricePerKilometer;
    }


    public VehicleCategory getCategory() {
        return this.category;
    }

    public String getAsString() {
        return String.format("Passenger capacity: %d\n" +
                        "Price per kilometer: %.2f\n" +
                        "Vehicle type: %s",
                getPassengerCapacity(), getPricePerKilometer(), getType());
    }

    public abstract VehicleType getType();

    public abstract VehicleCategory getVehicleCategory();

    private void setId(int value) {
        ValidationHelper.againstNegativeValue(value, INVALID_ID);
        this.id = value;
    }

    private void setPassengerCapacity(int value) {
        ValidationHelper.validatePassengerCapacity
                (value, MIN_PASSENGER_ERROR, MAX_PASSENGER_ERROR, INVALID_PASSENGER_CAPACITY_ERROR_MESSAGE);
        ValidationHelper.againstNull(value, VEHICLE_PASSENGER_NULL_ERROR);
        this.passengerCapacity = value;
    }

    private void setPricePerKilometer(double value) {
        ValidationHelper.validatePricePerKilometers(value,
                MIN_PRICE_ERROR, MAX_PRICE_ERROR, INVALID_PRICE_PER_KM_ERROR);
        ValidationHelper.againstNull(value, INVALID_NEGATIVE_PRICE_KM);
        this.pricePerKilometer = value;

    }

    private void setCategory(VehicleCategory category) {
        ValidationHelper.againstNull(category, INVALID_VEHICLE_CATEGORY);
        this.category = category;
    }

    private void setType(VehicleType type) {
        ValidationHelper.againstNull(type, INVALID_VEHICLE_TYPE);
        this.type = type;
    }
}


