package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;

public class TrainImpl extends VehicleImpl implements Train {

    private static final int PASSENGER_MIN_VALUE = 30;
    private static final int PASSENGER_MAX_VALUE = 150;
    private static final String CAPACITY_ERROR = String.format(
            "A train cannot have less than %d passengers or more than %d passengers.",
            PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    private static final int CARTS_MIN_VALUE = 1;
    private static final int CARTS_MAX_VALUE = 15;
    public static final String CARTS_ERROR = String.format(
            "A train cannot have less than %d cart or more than %d carts.",
            CARTS_MIN_VALUE, CARTS_MAX_VALUE);
    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
        setCarts(carts);
    }

    @Override
    public String getAsString() {
            StringBuilder output = new StringBuilder();
            output.append(String.format("Train ----%n")).append(super.getAsString()).append(System.getProperty("line.separator"));
            output.append(String.format("Carts amount: %d", carts)).append(System.getProperty("line.separator"));
            return output.toString();
    }

    @Override
    public int getCarts() {
        return carts;
    }

    @Override
    protected void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(CAPACITY_ERROR);
        }
        this.passengerCapacity = passengerCapacity;
    }

    private void setCarts(int carts) {
        if (carts < CARTS_MIN_VALUE || carts > CARTS_MAX_VALUE) {
            throw new IllegalArgumentException(CARTS_ERROR);
        }
        this.carts = carts;
    }
}