package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.contracts.Product;

public class ProductImpl implements Product {
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 10;
    private static final String PRODUCT_NAME_ERROR = String.format(
            "Product name should be between %d and %d symbols.", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    public static final int MIN_BRAND_LENGTH = 2;
    public static final int MAX_BRAND_LENGTH = 10;
    public static final String BRAND_NAME_LENGTH_ERROR = String.format
            ("Product brand should be between %d and %d symbols.", MIN_BRAND_LENGTH, MAX_BRAND_LENGTH);
    public static final double MIN_PRICE_VALUE = 0.0;
    public static final String PRICE_ERROR_MESSAGE = "Price can't be negative.";
    private String name;
    private String brand;
    private double price;
    private final GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        try {
            validateName(name);
            this.name = name;
        } catch (InvalidUserInputException e) {
            System.out.println(PRODUCT_NAME_ERROR + e.getMessage());
        }
    }

    private static void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidUserInputException(PRODUCT_NAME_ERROR);
        }
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        try {
            validateBrand(brand);
            this.brand = brand;
        } catch (InvalidUserInputException e) {
            System.out.println(BRAND_NAME_LENGTH_ERROR + e.getMessage());
        }
    }

    private static void validateBrand(String brand) {
        if (brand.length() < MIN_BRAND_LENGTH || brand.length() > MAX_BRAND_LENGTH) {
            throw new InvalidUserInputException(BRAND_NAME_LENGTH_ERROR);
        }
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        try {
            validatePrice(price);
            this.price = price;
        } catch (InvalidUserInputException e) {
            System.out.println(PRICE_ERROR_MESSAGE + e.getMessage());
        }
    }

    private  void validatePrice(double price) {
        if (price < MIN_PRICE_VALUE) {
            throw new InvalidUserInputException(PRICE_ERROR_MESSAGE);
        }
    }

    public GenderType getGender() {
        return gender;
    }


    @Override
    public String print() {
        return String.format(
                "#%s %s%n" +
                        " #Price: $%.2f%n" +
                        " #Gender: %s%n",
                name,
                brand,
                price,
                gender);
    }
}
