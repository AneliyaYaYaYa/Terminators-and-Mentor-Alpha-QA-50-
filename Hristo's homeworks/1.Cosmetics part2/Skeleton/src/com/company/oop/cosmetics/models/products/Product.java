package com.company.oop.cosmetics.models.products;

import com.company.oop.cosmetics.models.common.GenderType;

public class Product {

    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 10;
    public static final String NAME_LENGTH_ERROR = String.format
            ("Product name must be between %d and %d characters.",
                    MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    private static final int MIN_BRAND_LENGTH = 2;
    private static final int MAX_BRAND_LENGTH = 10;
    public static final String BRAND_LENGTH_ERROR = String.format
            ("Brand name must be between %d and %d characters.",
                    MIN_BRAND_LENGTH, MAX_BRAND_LENGTH);
    public static final String PRICE_ERROR = "Price cannot be negative.";
    public static final String INVALID_GENDER =
            "Invalid gender type. Allowed values: Men, Women, Unisex.";


    private double price;
    private String name;
    private String brand;

    private GenderType gender;


    public Product(String name, String brand, double price, GenderType gender) {
        setPrice(price);
        setName(name);
        setBrand(brand);
        setGender(gender);

    }

    private void setPrice(double price) {
        if (price < 0.00) {
            throw new IllegalArgumentException(PRICE_ERROR);
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    private void setName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setBrand(String brand) {
        if (brand.length() < MIN_BRAND_LENGTH || brand.length() > MAX_BRAND_LENGTH) {
            throw new IllegalArgumentException(BRAND_LENGTH_ERROR);
        }

        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }


    private void setGender(GenderType gender) {
        if (gender == null) {
            throw new IllegalArgumentException(INVALID_GENDER);
        }
        this.gender = gender;
    }

    public GenderType getGender() {
        return gender;
    }


    public String print() {
        return String.format(" #%s %s\n" +
                " #Price: $%.2f\n" +
                " #Gender: %s\n" +
                " ===", name, brand, price, gender);
    }

}

