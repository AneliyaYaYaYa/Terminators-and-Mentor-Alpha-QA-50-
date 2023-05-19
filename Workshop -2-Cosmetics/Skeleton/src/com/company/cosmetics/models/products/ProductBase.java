package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;


public class ProductBase implements Product {
    //Finish the class
    //What variables, what constants should you write here?
    //validate

    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    ProductBase(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);

    }

    public void setName(String value) {
        if (value == null || value.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
        if (value.length() < 3 || value.length() > 10) {
            throw new IllegalArgumentException("Minimum name’s length is 3 symbols and maximum is 10 symbols.");
        }
        this.name = value;
    }

    public void setBrand(String value) {
        if (value == null || value.isEmpty()){
            throw new IllegalArgumentException("Brand name's cannot be null");
        }
        if (value.length() < 2 || value.length() > 10) {
            throw new IllegalArgumentException("Minimum brand name’s length is 2 symbols and maximum is 10 symbols.");
        }
        this.brand = value;
    }

    public void setPrice(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = value;
    }

    public void setGender(GenderType gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null.");
        }
        this.gender = gender;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public GenderType getGender() {
        return this.gender;
    }

    @Override
    public String print() {

        return String.format("#%s %s\n  #Price: %.2f\n  #Gender: %s\n"
                , name, brand, price, gender);

    }
}