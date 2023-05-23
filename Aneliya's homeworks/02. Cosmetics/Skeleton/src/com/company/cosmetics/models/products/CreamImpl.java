package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Cream;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;


public class CreamImpl extends ProductBase implements Cream {

    private static final String SCENT_NULL_ERROR = "Scent type cannot be null.";
    private ScentType scent;

    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price, gender);
        setScent(scent);
    }

    private void setScent(ScentType scent) {
        if (scent == null) {
            throw new IllegalArgumentException(SCENT_NULL_ERROR);
        }
        this.scent = scent;
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

        return String.format("%s%n #Scent: %s%n ===", super.print(), getScent());
    }

    @Override
    public ScentType getScent() {
        return scent;
    }
}
