package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {

    private static final int MIN_MILLILITERS = 0;

    private static final String MILLILITERS_ERROR = "Milliliters cannot be negative.";

    private int milliliters;

    private final UsageType everyday;

    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType everyDay) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        this.everyday = everyDay;
    }

    private void setMilliliters(int milliliters) {
        if (milliliters < MIN_MILLILITERS) {
            throw new IllegalArgumentException(MILLILITERS_ERROR);
        }
        this.milliliters = milliliters;
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
        return String.format("%s%n #Milliliters: %d%n #Usage: %s%n ===", super.print(), getMilliliters(), getUsage());
    }

    @Override
    public int getMilliliters() {
        return milliliters;
    }

    @Override
    public UsageType getUsage() {
        return everyday;
    }
}
