package com.company.oop.agency.models.vehicles.contracts;

import com.company.oop.agency.models.contracts.Identifiable;
import com.company.oop.agency.models.contracts.Printable;
import com.company.oop.agency.models.vehicles.VehicleType;

public interface Vehicle extends Identifiable, Printable {

    VehicleType getType();

    int getPassengerCapacity();

    double getPricePerKilometer();

}