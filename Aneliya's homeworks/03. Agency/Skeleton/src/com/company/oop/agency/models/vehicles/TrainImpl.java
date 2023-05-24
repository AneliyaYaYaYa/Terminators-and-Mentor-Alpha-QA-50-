package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;

public class TrainImpl implements Train {

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
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    private static final String PRICE_PER_KM_ERROR = String.format("" +
            "A vehicle with a price per kilometer lower than $%.2f " +
            "or higher than $%.2f cannot exist!", PRICE_MIN_VALUE, PRICE_MAX_VALUE);
    private int id;
    private int passengerCapacity;
    private double pricePerKm;
    private int carts;
    private VehicleType vehicle;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        this.id = id;
        setPassengerCapacity(passengerCapacity);
        setPricePerKm(pricePerKilometer);
        setCarts(carts);
        vehicle = VehicleType.LAND;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Train ----%nPassenger capacity: %d%nPrice per kilometer: %.2f%nVehicle type: %s%nCarts amount: %d%n", passengerCapacity, pricePerKm, vehicle,carts);
    }

    @Override
    public int getCarts() {
            return carts;
    }

    @Override
    public VehicleType getType() {
        return vehicle;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKm;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(CAPACITY_ERROR);
        }
        this.passengerCapacity = passengerCapacity;
    }

    public void setPricePerKm(double pricePerKm) {
        if (pricePerKm < PRICE_MIN_VALUE || pricePerKm > PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(PRICE_PER_KM_ERROR);
        }
        this.pricePerKm = pricePerKm;
    }

    private void setCarts(int carts) {
        if (carts <CARTS_MIN_VALUE || carts > CARTS_MAX_VALUE) {
            throw new IllegalArgumentException(CARTS_ERROR);
        }
        this.carts = carts;
    }
}