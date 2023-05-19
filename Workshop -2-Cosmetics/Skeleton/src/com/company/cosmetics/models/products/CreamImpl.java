package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Cream;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;


public class CreamImpl extends ProductBase implements Cream {

    private ScentType scent;

    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name,brand,price,gender);
        setScent(scent);
    }

    public void setScent(ScentType value) {
        if (value != ScentType.ROSE && value != ScentType.VANILLA && value != ScentType.LAVENDER ){
            throw new IllegalArgumentException("Invalid scent type. Allowed values: Rose, Vanilla, Lavender.");
        }
        this.scent = value;
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
       return  super.getGender();
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
