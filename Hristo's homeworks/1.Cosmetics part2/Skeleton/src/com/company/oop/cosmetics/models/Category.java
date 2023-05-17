package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 15;
    public static final String CATEGORY_NAME_ERROR = String.format
            ("Invalid category name. Category name must be between %d and %d characters.",
                    MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    public static final String PRODUCT_ERROR = "Product cannot be null.";
    public static final String PRODUCT_NOT_FOUND_ERROR = "Product not found in the category.";
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
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CATEGORY_NAME_ERROR);
        }
        this.name = name;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);  //// need to return copies of the productList not address

    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException(PRODUCT_ERROR);
        }
        products.add(product);

    }

    public void removeProduct(Product product) {
        if (!products.contains(product)) {
            throw new IllegalArgumentException(PRODUCT_NOT_FOUND_ERROR);
        }
        products.remove(product);
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder(String.format("#Category: %s\n", name));

        if(products.isEmpty()){
            stringBuilder.append(" #No product in this category");
        }

        for (Product item: products) {
            stringBuilder.append(item.print());
        }

        return stringBuilder.toString();
    }

}
