package com.company.oop.agency.models.vehicles;
import com.company.oop.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehiclesBase implements Airplane {

    private static final int PASSENGER_MIN_VALUE = 1;
    private static final int PASSENGER_MAX_VALUE = 800;
    private static final String CAPACITY_ERROR = String.format(
            "An airplane cannot have less than %d passengers or more than %d passengers.",
            PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    private int id;
    private int passengerCapacity;
    private boolean hasFreeFood;
    private VehicleType vehicle;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(pricePerKilometer);
        setPassengerCapacity(passengerCapacity);
        this.id = id;
        this.hasFreeFood = hasFreeFood;
        vehicle = VehicleType.AIR;

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Airplane ----%nPassenger capacity: %d%n", passengerCapacity)).append(print()).append(getType()).append(System.getProperty("line.separator"));
        output.append(String.format("Has free food: %s", hasFreeFood)).append(System.getProperty("line.separator"));
        return output.toString();
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
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

    private void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(CAPACITY_ERROR);
        }
        this.passengerCapacity = passengerCapacity;
    }
}