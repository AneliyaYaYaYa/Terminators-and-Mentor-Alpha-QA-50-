package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public class VehicleImpl implements Vehicle {
    private static final double PRICE_PER_KM_MIN = 0.10;
    private static final double PRICE_PER_KM_MAX = 2.5;
    private static final String PRICE_PER_KM_ERROR = String.format("" +
            "A vehicle with a price per kilometer lower than $%.2f " +
            "or higher than $%.2f cannot exist!", PRICE_PER_KM_MIN, PRICE_PER_KM_MAX);
    private static final int PASSENGER_MIN_VALUE = 1;
    private static final int PASSENGER_MAX_VALUE = 800;
    private static final String CAPACITY_ERROR = String.format(
            "A vehicle with less than %d passengers or more than %d passengers cannot exist!.",
            PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    protected int id;
    protected int passengerCapacity;
    protected double pricePerKm;
    protected VehicleType type;

    public VehicleImpl(int id, int passengerCapacity, double pricePerKm, VehicleType type) {
        this.id = id;
        setPassengerCapacity(passengerCapacity);
        setPricePerKm(pricePerKm);
        this.type = type;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Passenger capacity: %d%nPrice per kilometer: %.2f%nVehicle type: %s",passengerCapacity, pricePerKm, type);
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKm;
    }

    private void setPricePerKm(double pricePerKm) {
        if (pricePerKm < PRICE_PER_KM_MIN || pricePerKm > PRICE_PER_KM_MAX) {
            throw new IllegalArgumentException(PRICE_PER_KM_ERROR);
        }
        this.pricePerKm = pricePerKm;
    }

    protected void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(CAPACITY_ERROR);
        }
        this.passengerCapacity = passengerCapacity;
    }

}
