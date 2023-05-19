package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {
    
    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType everyDay) {
        super();
        throw new UnsupportedOperationException("Not implemented yet. ShampooImpl class");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not implemented yet. ShampooImpl class");
    }

    @Override
    public String getBrand() {
        throw new UnsupportedOperationException("Not implemented yet. ShampooImpl class");
    }

    @Override
    public double getPrice() {
        throw new UnsupportedOperationException("Not implemented yet. ShampooImpl class");
    }

    @Override
    public GenderType getGender() {
        throw new UnsupportedOperationException("Not implemented yet. ShampooImpl class");
    }

    @Override
    public String print() {
        throw new UnsupportedOperationException("Not implemented yet. ShampooImpl class");
    }

    @Override
    public int getMilliliters() {
        throw new UnsupportedOperationException("Not implemented yet. ShampooImpl class");
    }

    @Override
    public UsageType getUsage() {
        throw new UnsupportedOperationException("Not implemented yet. ShampooImpl class");
    }
}
