package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;

public class BusImpl extends VehicleImpl implements Bus {

    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;
    private static final String CAPACITY_ERROR = String.format(
            "A bus cannot have less than %d passengers or more than %d passengers.",
            PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
    }
    @Override
    public String getAsString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Bus ----%n")).append(super.getAsString()).append(System.getProperty("line.separator"));
        return output.toString();
    }
    @Override
    protected void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(CAPACITY_ERROR);
        }
        this.passengerCapacity = passengerCapacity;
    }
}