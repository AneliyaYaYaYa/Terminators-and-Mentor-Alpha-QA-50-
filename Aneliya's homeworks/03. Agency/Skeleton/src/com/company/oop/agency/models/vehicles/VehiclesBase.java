package com.company.oop.agency.models.vehicles;

public class VehiclesBase {

    private static final double PRICE_PER_KM_MIN = 0.10;
    private static final double PRICE_PER_KM_MAX = 2.5;
    private static final String PRICE_PER_KM_ERROR = String.format("" +
            "A vehicle with a price per kilometer lower than $%.2f " +
            "or higher than $%.2f cannot exist!", PRICE_PER_KM_MIN, PRICE_PER_KM_MAX);

    protected double pricePerKm;
    public VehiclesBase( double pricePerKm) {
        setPricePerKm(pricePerKm);
    }

    protected void setPricePerKm(double pricePerKm) {
        if (pricePerKm < PRICE_PER_KM_MIN || pricePerKm > PRICE_PER_KM_MAX) {
            throw new IllegalArgumentException(PRICE_PER_KM_ERROR);
        }
        this.pricePerKm = pricePerKm;
    }

    public String print() {
        return String.format("Price per kilometer: %.2f%nVehicle type: ", pricePerKm);

    }

}
