package com.company.oop.agency.commands.enums;

public enum VehicleCategory {
    BUS,
    TRAIN,
    AIRPLANE;
    public String toString() {
        switch (this) {
            case BUS:
                return "Bus";
            case TRAIN:
                return "Train";
            case AIRPLANE:
                return "Airplane";

            default:
                throw new IllegalArgumentException("Invalid VehicleType" + this);
        }
    }
}
