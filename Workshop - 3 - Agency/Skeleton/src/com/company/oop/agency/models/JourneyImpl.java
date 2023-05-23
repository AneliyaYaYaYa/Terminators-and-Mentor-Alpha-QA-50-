package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public class JourneyImpl implements Journey {

    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MAX_LENGTH = 25;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int DESTINATION_MAX_LENGTH = 25;
    private static final String START_LOCATION_ERROR_MESSAGE = "The StartingLocation's length cannot be less than 5 or more than 25 symbols long.";
    private static final String DESTINATION_ERROR_MESSAGE = "The Destination's length cannot be less than 5 or more than 25 symbols long.";
    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DISTANCE_MAX_VALUE = 5000;
    private static final String DISTANCE_ERROR_MESSAGE = "The Distance cannot be less than 5 or more than 5000 kilometers.";

    private int id;
    private int distance;
    private Vehicle vehicle;
    private String destination;
    private String startLocation;

    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        setId(id);
        setVehicle(vehicle);
        setDistance(distance);
        setDestination(destination);
        setStartLocation(startLocation);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public double calculateTravelCosts() {
        return distance * vehicle.getPricePerKilometer();
    }

    @Override
    public String getAsString() {
        return String.format(
                "Journey ----\n" +
                "Start location: %s\n" +
                "Destination: %s\n" +
                "Distance: %d\n" +
                "Vehicle type: %s\n" +
                "Travel costs: %.2f\n",
                startLocation,
                destination,
                distance,
                vehicle.getType(),
                calculateTravelCosts());
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setStartLocation(String startLocation) {
        ValidationHelper.validateStringLength(
                startLocation,
                START_LOCATION_MIN_LENGTH,
                START_LOCATION_MAX_LENGTH,
                START_LOCATION_ERROR_MESSAGE);
        this.startLocation = startLocation;
    }

    private void setDestination(String destination) {
        ValidationHelper.validateStringLength(
                destination,
                DESTINATION_MIN_LENGTH,
                DESTINATION_MAX_LENGTH,
                DESTINATION_ERROR_MESSAGE);
        this.destination = destination;
    }

    private void setDistance(int distance) {
        ValidationHelper.validateValueInRange(
                distance,
                DISTANCE_MIN_VALUE,
                DISTANCE_MAX_VALUE,
                DISTANCE_ERROR_MESSAGE);
        this.distance = distance;
    }

    private void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}