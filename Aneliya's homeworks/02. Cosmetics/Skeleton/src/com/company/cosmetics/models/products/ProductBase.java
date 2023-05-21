package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;


public class ProductBase implements Product {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final String NAME_ERROR_MESSAGE = String.format(
            "Name's length must be between %d and %d characters.",
            NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    private static final int BRAND_NAME_MIN_LENGTH = 2;
    private static final String BRAND_NAME_ERROR = String.format("Brand name's length must be between %d and %d characters.",
            BRAND_NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    private static final int MIN_PRICE = 0;
    private static final String PRICE_ERROR = "Price cannot be negative.";
    private static final String NAME_NULL_ERROR = "Name cannot be null.";
    private String name;
    private String brand;
    private double price;
    private final GenderType gender;

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
        if (brand.length() < BRAND_NAME_MIN_LENGTH || brand.length() > NAME_MAX_LENGTH) {
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
        return String.format("#%s %s%n #Price: $%.2f%n #Gender: %s", getName(), getBrand(), getPrice(), getGender());
    }
}
