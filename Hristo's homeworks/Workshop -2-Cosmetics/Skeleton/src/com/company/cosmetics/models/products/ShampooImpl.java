package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {

    private static final String MILLILITERS_ERROR_EMPTY = "Milliliters cannot be negative number";
    private int milliliters;
    UsageType everyDay;

    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType everyDay) {
        super(name, brand, price, gender);

        validateMilliliters(milliliters);
        this.milliliters = milliliters;

        setEveryDay(everyDay);
    }

    private void setMilliliters(int value) {
        validateMilliliters(value);
        this.milliliters = value;
    }

    private static void validateMilliliters(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(MILLILITERS_ERROR_EMPTY);
        }
    }

    public UsageType getEveryDay() {
        return this.everyDay;
    }

    private void setEveryDay(UsageType everyDay) {
        this.everyDay = everyDay;
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
        return String.format("%s\n #Milliliters: %d\n #Usage: %s", adultPrint, milliliters, everyDay);
    }

    @Override
    public int getMilliliters() {
        return this.milliliters;
    }

    @Override
    public UsageType getUsage() {
        return this.everyDay;
    }
}
