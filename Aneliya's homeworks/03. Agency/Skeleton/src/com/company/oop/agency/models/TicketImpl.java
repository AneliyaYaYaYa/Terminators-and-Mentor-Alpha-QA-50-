package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    private static final int COSTS_MIN_VALUE = 0;
    private int id;
    private Journey journey;
    private double costs;

    public TicketImpl(int id, Journey journey, double costs) {
        this.id = id;
        this.journey = journey;
        setCosts(costs);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Ticket ----\n" +
                "Destination: %s\n" +
                "Price: %.2f%n", getJourney().getDestination(), calculatePrice());
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return costs * getJourney().calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return costs;
    }

    public void setCosts(double costs) {
        if (costs < COSTS_MIN_VALUE) {
            throw new InvalidUserInputException(String.format(
                    "Value of 'costs' must be a positive number. Actual value: %.2f.",costs));
        }
        this.costs = costs;
    }
}
