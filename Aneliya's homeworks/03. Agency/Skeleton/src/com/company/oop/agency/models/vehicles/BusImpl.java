package com.company.oop.agency.models.vehicles;
import com.company.oop.agency.models.vehicles.contracts.Bus;

public class BusImpl extends VehiclesBase implements Bus {

    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    private static final String CAPACITY_ERROR = String.format(
            "A bus cannot have less than %d passengers or more than %d passengers.",
            PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    private static final String PRICE_PER_KM_ERROR = String.format("" +
            "A vehicle with a price per kilometer lower than $%.2f " +
            "or higher than $%.2f cannot exist!", PRICE_MIN_VALUE, PRICE_MAX_VALUE);
    private int id;
    private  int passengerCapacity;
    private VehicleType vehicle;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(pricePerKilometer);
        setPassengerCapacity(passengerCapacity);
        this.id = id;
        vehicle = VehicleType.LAND;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Bus ----%nPassenger capacity: %d%n", passengerCapacity)).append(print()).append(getType()).append(System.getProperty("line.separator"));
        return output.toString();
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