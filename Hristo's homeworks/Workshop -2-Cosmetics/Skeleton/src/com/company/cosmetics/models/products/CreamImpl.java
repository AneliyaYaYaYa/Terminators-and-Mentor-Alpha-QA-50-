package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Cream;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;


public class CreamImpl extends ProductBase implements Cream {

    private static final String INVALID_SCENT_TYPE = "Invalid scent type. Allowed values: Rose, Vanilla, Lavender.";
    private ScentType scent;

    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price, gender);
        validateScent(scent);
        this.scent = scent;
    }

    private void setScent(ScentType value) {
        validateScent(value);
        this.scent = value;
    }

    private static void validateScent(ScentType value) {
        if (value != ScentType.ROSE && value != ScentType.VANILLA && value != ScentType.LAVENDER) {
            throw new IllegalArgumentException(INVALID_SCENT_TYPE);
        }
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public GenderType getGender() {
        return super.getGender();
    }

    @Override
    public String print() {
        String adultPrint = super.print();
        return String.format("%s\n #Scent: %s", adultPrint, getScent());
    }

    @Override
    public ScentType getScent() {
        return this.scent;
    }
}
