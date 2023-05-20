package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;


public class ProductBase implements Product {
    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final String NAME_ERROR_MESSAGE = String.format(
            "Name's length must be between %d and %d characters.",
            NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    public static final int BRAND_NAME_MIN_LENGTH = 2;
    public static final String BRAND_NAME_ERROR = String.format("Brand name's length must be between %d and %d characters.",
            BRAND_NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    public static final int MIN_PRICE = 0;
    public static final String PRICE_ERROR = "Price cannot be negative.";
    public static final String NAME_NULL_ERROR = "Name cannot be null.";
    private String name;
    private String brand;
    private double price;
    private GenderType gender;
    
    public ProductBase(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    private void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(NAME_NULL_ERROR);
        }
        validateName(name);
        this.name = name;
    }

    private void setBrand(String brand) {
        if (brand == null) {
            throw new IllegalArgumentException(NAME_NULL_ERROR);
        }
        validateBrandName(brand);
        this.brand = brand;
    }

    private void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }

    private static void validatePrice(double price) {
        if (price < MIN_PRICE) {
           throw new IllegalArgumentException(PRICE_ERROR);
        }
    }

    private static void validateBrandName(String brand) {
        if (brand.length() < BRAND_NAME_MIN_LENGTH || brand.length() >NAME_MAX_LENGTH ) {
            throw new IllegalArgumentException(BRAND_NAME_ERROR);
        }
    }

    private static void validateName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not implemented yet. ProductBase class");
    }

    @Override
    public String getBrand() {
        throw new UnsupportedOperationException("Not implemented yet. ProductBase class");
    }

    @Override
    public double getPrice() {
        price += getPrice();
        return getPrice();
        //throw new UnsupportedOperationException("Not implemented yet. ProductBase class");
    }

    @Override
    public GenderType getGender() {
        throw new UnsupportedOperationException("Not implemented yet. ProductBase class");
    }

    @Override
    public String print() {
        throw new UnsupportedOperationException("Not implemented yet. ProductBase class");
    }
}
