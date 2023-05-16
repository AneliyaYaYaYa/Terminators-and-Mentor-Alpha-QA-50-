package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {

    public static final int MIN_CATEGORY_NAME = 2;
    public static final int MAX_CATEGORY_NAME = 15;
    public static final String CATEGORY_NAME_ERROR = String.format("Minimum category name’s length is %d symbols and maximum is %d symbols",
            MIN_CATEGORY_NAME, MAX_CATEGORY_NAME);
    private String name;
    private List<Product> products;

    public Category(String name) {
        products = new ArrayList<>();
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.length() < MIN_CATEGORY_NAME || name.length() > MAX_CATEGORY_NAME) {
            throw new IllegalArgumentException(
                    CATEGORY_NAME_ERROR);
        }
        this.name = name;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        if(!products.contains(product)){
            throw new IllegalArgumentException("Product is not in this category");
        }
        products.remove(product);
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder(String.format("#Category: %s%n", name));

        if(products.isEmpty()){
            stringBuilder.append(" #No product in this category");
        }

        for (Product item: products) {
            stringBuilder.append(item.print());
        }

        return stringBuilder.toString();
    }

}
