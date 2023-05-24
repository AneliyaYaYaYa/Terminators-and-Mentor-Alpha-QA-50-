package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.commands.enums.VehicleCategory;
import com.company.oop.agency.commands.enums.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends VehicleImpl implements Bus {

    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;
    public static final String INVALID_PASSENGER_CAPACITY_ERROR = String.format("A bus cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    public static final String PASSENGERS_CANNOT_BE_NEGATIVE = "Passengers cannot be negative";

    private int passengerCapacity;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer);
        setPassengerCapacity(passengerCapacity);
    }


    @Override
    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }


    @Override
    public String getAsString() {
        return String.format("%s ----\n" +
                "Passenger capacity: %d\n" +
                "Price per kilometer: %.2f\n" +
                "Vehicle type: %s\n",getVehicleCategory(),getPassengerCapacity(),getPricePerKilometer(),getType());
    }

    @Override
    public VehicleType getType() {
        return VehicleType.LAND;

    }

    public VehicleCategory getVehicleCategory() {
        return VehicleCategory.BUS;
    }

    private void setPassengerCapacity(int value) {
        ValidationHelper.validatePassengerCapacity(
                value, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, INVALID_PASSENGER_CAPACITY_ERROR);
        ValidationHelper.againstNull(value, PASSENGERS_CANNOT_BE_NEGATIVE);
        this.passengerCapacity = value;
    }
}

