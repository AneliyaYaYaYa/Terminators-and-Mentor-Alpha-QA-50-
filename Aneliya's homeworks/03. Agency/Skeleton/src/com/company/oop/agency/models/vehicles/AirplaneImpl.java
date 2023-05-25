package com.company.oop.agency.models.vehicles;
import com.company.oop.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleImpl implements Airplane {

    private static final int PASSENGER_MIN_VALUE = 1;
    private static final int PASSENGER_MAX_VALUE = 800;
    private static final String CAPACITY_ERROR = String.format(
            "An airplane cannot have less than %d passengers or more than %d passengers.",
            PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);

    private boolean hasFreeFood;


    public AirplaneImpl(int id, int passengerCapacity, double pricePerKm, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKm, VehicleType.AIR);
        this.hasFreeFood = hasFreeFood;
    }

    @Override
    public String getAsString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Airplane ----%n")).append(super.getAsString()).append(System.getProperty("line.separator"));
        output.append(String.format("Has free food: %s", hasFreeFood)).append(System.getProperty("line.separator"));
        return output.toString();
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    @Override
    protected void setPassengerCapacity(int passengerCapacity) {

        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(CAPACITY_ERROR);
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKm;
    }
}