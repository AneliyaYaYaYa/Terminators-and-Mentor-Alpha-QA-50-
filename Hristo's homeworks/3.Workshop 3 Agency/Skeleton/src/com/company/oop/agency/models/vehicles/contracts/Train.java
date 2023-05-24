package com.company.oop.agency.models.vehicles.contracts;

import com.company.oop.agency.commands.enums.VehicleType;

public interface Train extends Vehicle {


    int getCarts();

    int id();

    int getPassengerCapacity();

    double getPricePerKilometer();

    VehicleType getType();

}