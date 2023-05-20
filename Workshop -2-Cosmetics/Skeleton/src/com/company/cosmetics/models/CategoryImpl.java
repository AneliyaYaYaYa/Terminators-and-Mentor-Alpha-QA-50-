package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 15;
    private static final String INVALID_NAME_CATEGORY =String.format(
            "Invalid category name. Category name must be between %d and %d characters.",MIN_NAME_LENGTH,MAX_NAME_LENGTH);
    private static final String NULL_ERROR_MESSAGE = "Product cannot be null";


    private String name;
    private final List<Product> products;

    public CategoryImpl(String name) {
        validateName(name);
        this.name = name;
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        //This helps maintain data integrity and encapsulation because
        //the caller cannot modify the original list directly.
        //If you were to simply return the products list directly,
        //the caller would have direct access to the internal list and could modify it freely.
        //By returning a copy, you maintain control over how the list can be accessed and modified.
        return new ArrayList<>(products);
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
        products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);

    }

    private static void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_CATEGORY);
        }
    }

    public String print() {

        StringBuilder result = new StringBuilder(String.format("#Category: %s%n", name));

        if (products.size() == 0) {
            result.append(" #No product in this category");

        } else {
            for (Product product : products) {
                result.append(product.print()).append("\n ===\n");
            }
        }
        return result.toString().trim();  // trim  - to remove all whitespace from strings.
    }
}



