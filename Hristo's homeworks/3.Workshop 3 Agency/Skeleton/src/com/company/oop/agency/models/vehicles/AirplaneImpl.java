package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.commands.enums.VehicleCategory;
import com.company.oop.agency.commands.enums.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Airplane;


public class AirplaneImpl extends VehicleImpl implements Airplane {
    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKilometer);
        setHasFreeFood(hasFreeFood);
    }


    @Override
    public String getAsString() {
        return String.format("%s ----\n" +
                        "Passenger capacity: %d\n" +
                        "Price per kilometer: %.2f\n" +
                        "Vehicle type: %s\n" +
                        "Has free food: %b\n",
                getVehicleCategory(), getPassengerCapacity(), getPricePerKilometer(), getType(), hasFreeFood);
    }

    @Override
    public boolean hasFreeFood() {
        return true;
    }


    @Override
    public VehicleType getType() {
        return VehicleType.AIR;
    }

    @Override
    public VehicleCategory getVehicleCategory() {
        return VehicleCategory.AIRPLANE;
    }

    public boolean isHasFreeFood() {
        return this.hasFreeFood;
    }

    private void setHasFreeFood(boolean value) {
        this.hasFreeFood = value;
    }
}

