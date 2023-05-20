package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Cream;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;


public class CreamImpl extends ProductBase implements Cream {

    private ScentType scent;
    
    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price, gender);
        this.scent = scent;
        //throw new UnsupportedOperationException("Not implemented yet. CreamImpl Class");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not implemented yet. CreamImpl Class");
    }

    @Override
    public String getBrand() {
        throw new UnsupportedOperationException("Not implemented yet. CreamImpl Class");
    }

    @Override
    public double getPrice() {
        return getPrice();
        //throw new UnsupportedOperationException("Not implemented yet. CreamImpl Class");
    }

    @Override
    public GenderType getGender() {
        throw new UnsupportedOperationException("Not implemented yet. CreamImpl Class");
    }

    @Override
    public String print() {
        throw new UnsupportedOperationException("Not implemented yet. CreamImpl Class");
    }

    @Override
    public ScentType getScent() {
        throw new UnsupportedOperationException("Not implemented yet. CreamImpl Class");
    }
}
