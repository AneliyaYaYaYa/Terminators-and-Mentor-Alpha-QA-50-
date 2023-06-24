package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.Category;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class CategoryImpl implements Category {

    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 10;
    private static final String CATEGORY_NAME_ERROR = String.format(
            "Category name should be between %d and %d symbols.", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    private String name;
    private final List<Product> products;

    public CategoryImpl(String name) {
        setName(name);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        try {
            validateName(name);
            this.name = name;
        } catch (InputMismatchException e) {
            System.out.println(CATEGORY_NAME_ERROR + e.getMessage());
        }
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CATEGORY_NAME_ERROR);
        }
    }
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public String print() {
        if (products.size() == 0) {
            return String.format(
                    "#Category: %s%n" +
                            " #No product in this category",
                    name);
        }
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(String.format("#Category: %s%n", name));

        for (Product product : products) {
            strBuilder.append(product.print());
            strBuilder.append(String.format(" ===%n"));
        }
        return strBuilder.toString();
    }

}
