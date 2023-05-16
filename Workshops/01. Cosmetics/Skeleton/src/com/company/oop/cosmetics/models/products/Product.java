package com.company.oop.cosmetics.models.products;

import com.company.oop.cosmetics.models.common.GenderType;

public class Product {
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 10;
    private static final int MIN_BRAND_LENGTH = 2;
    private static final int MAX_BRAND_LENGTH = 10;
    private static final int MIN_PRICE = 0;
    private double price;
    private String name;
    private String brand;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        createProduct(name, brand, price, gender);
    }

    private void createProduct(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    //begin setters
    private void setName(String name) {
        if (name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH)
            this.name = name;
        else throw new IllegalArgumentException("Invalid name");
    }

    private void setBrand(String brand) {
        if (brand.length() >= MIN_BRAND_LENGTH && brand.length() <= Product.MAX_BRAND_LENGTH)
            this.brand = brand;
        else throw new IllegalArgumentException("Invalid brand");
    }

    private void setPrice(double price) {
        if (price >= MIN_PRICE)
            this.price = price;
        else throw new IllegalArgumentException("Invalid price");
    }

    private void setGender(GenderType gender) {
        if (gender != null)
            this.gender = gender;
        else throw new IllegalArgumentException("Invalid gender");
    }

    //end setters
    public static String print(Product name) {
        return String.format(" #%s %s%n", name.name, name.brand) +
                String.format(" #Price: $%.2f%n", name.price) +
                String.format(" #Gender: %s%n", name.gender) +
                "===";
    }

    //get
    public double getPrice() {
        return price;
    }
}