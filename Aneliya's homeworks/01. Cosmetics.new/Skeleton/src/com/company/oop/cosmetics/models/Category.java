package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private static final int MIN_LENGTH_CATEGORY_NAME = 2;
    private static final int MAX_LENGTH_CATEGORY_NAME = 15;
    private static final String NAME_ERROR_MESSAGE = String.format(
            "Category name must be between %d and %d characters.",
            MIN_LENGTH_CATEGORY_NAME, MAX_LENGTH_CATEGORY_NAME);
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
        if (name.length() < MIN_LENGTH_CATEGORY_NAME || name.length() > MAX_LENGTH_CATEGORY_NAME) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);

        }
        if (name == null || name == "") {
            throw new IllegalArgumentException("Category name cannot be null.");
        }
        this.name = name;
    }


    public List<Product> getProducts() {
        return new ArrayList<>(products);
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        products.add(product);

    }
    
    public void removeProduct(Product product) {
        if (getProducts().contains(product)) {
            products.remove(product);
        }
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
//        if (!getProducts().contains(product)) {
//            throw new IllegalArgumentException("Product is not in this category.");
//        }
    }
    
    public String print() {
        StringBuilder stringBuilder = new StringBuilder(String.format("#Category: %s%n", name));
        if (products.isEmpty()) {
            stringBuilder.append(" #No product in this category");
        }
        for (Product item:products) {
            stringBuilder.append(item.print());
        }
        return stringBuilder.toString();

    }
    
}
