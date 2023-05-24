package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;


public class TicketImpl implements Ticket {
    private int id;
    private Journey journey;
    private double administrativeCosts;

    public TicketImpl(int id, Journey journey, double administrativeCosts) {
        setId(id);
        setJourney(journey);
        setCosts(administrativeCosts);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public Journey getJourney() {
        return this.journey;
    }

    @Override
    public double getAdministrativeCosts() {
        return this.administrativeCosts;
    }

    @Override
    public double calculatePrice() {
        return administrativeCosts * journey.calculateTravelCosts();
    }


    @Override
    public String getAsString() {
        return String.format("Ticket ----\n" +
                "Destination: %s\n" +
                "Price: %.2f\n", journey.getDestination(), calculatePrice());

    }


    private void setId(int id) {
        this.id = id;
    }

    private void setJourney(Journey journey) {
        this.journey = journey;
    }


    private void setCosts(double value) {
        if (value < 0.0) {
            throw new InvalidUserInputException(String.format("Value of 'costs' must be a positive number. Actual value: %.2f.", value));
        }
        this.administrativeCosts = value;
    }
}






