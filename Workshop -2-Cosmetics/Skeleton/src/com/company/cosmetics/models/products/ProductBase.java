package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;


public class ProductBase implements Product {
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 10;
    private static final String NAME_LENGTH_ERROR_MESSAGE = String.format("Minimum name’s length is %d symbols and maximum is %d symbols.", MIN_LENGTH, MAX_LENGTH);
    private static final String NULL_ERROR = "Name cannot be empty or null";
    private static final String BRAND_NULL_ERROR = "Brand name's cannot be null";
    private static final int MIN_LENGTH_BRAND = 2;
    private static final int MAX_LENGTH_BRAND = 10;
    private static final String BRAND_LENGTH_ERROR = String.format("Minimum brand name’s length is %d symbols and maximum is %d symbols.", MIN_LENGTH_BRAND, MAX_LENGTH_BRAND);
    private static final String NEGATIVE_PRICE = "Price cannot be negative.";
    private static final String GENDER_ERROR_MESSAGE = "Gender cannot be null.";
    //Finish the class
    //What variables, what constants should you write here?
    //validate

    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    protected ProductBase(String name, String brand, double price, GenderType gender) {
        validateName(name);
        this.name = name;

        validateBrand(brand);
        this.brand = brand;

        validatePrice(price);
        this.price = price;

        validateGender(gender);
        this.gender = gender;

    }

    private void setName(String value) {
        validateName(value);
        this.name = value;
    }

    private static void validateName(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(NULL_ERROR);
        }
        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void setBrand(String value) {
        validateBrand(value);
        this.brand = value;
    }

    private static void validateBrand(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(BRAND_NULL_ERROR);
        }
        if (value.length() < MIN_LENGTH_BRAND || value.length() > MAX_LENGTH_BRAND) {
            throw new IllegalArgumentException(BRAND_LENGTH_ERROR);
        }
    }

    private void setPrice(double value) {
        validatePrice(value);
        this.price = value;
    }

    private static void validatePrice(double value) {
        if (value < 0) {
            throw new IllegalArgumentException(NEGATIVE_PRICE);
        }
    }

    private void setGender(GenderType gender) {
        validateGender(gender);
        this.gender = gender;
    }

    private static void validateGender(GenderType gender) {
        if (gender == null) {
            throw new IllegalArgumentException(GENDER_ERROR_MESSAGE);
        }
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

        return String.format("#%s %s\n" +
                        " #Price: $%.2f\n" +
                        " #Gender: %s"
                , name, brand, price, gender);

    }
}