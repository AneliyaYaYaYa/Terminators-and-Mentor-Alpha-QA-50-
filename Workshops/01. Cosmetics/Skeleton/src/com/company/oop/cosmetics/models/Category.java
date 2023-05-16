package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {

    public static final int MIN_CATEGORY_LENGTH = 2;
    public static final int MAX_CATEGORY_LENGTH = 15;
    public static final int MIN_CATEGORY_ELEMENT = 0;
    private String name;
    private List<Product> products;

    //set
    public Category(String name) {
        createCategory(name);
    }

    private void createCategory(String name) {
        if (name.length() >= MIN_CATEGORY_LENGTH && name.length() <= MAX_CATEGORY_LENGTH) {
            this.name = name;
            this.products = new ArrayList<>();
        } else throw new IllegalArgumentException("Invalid category name");
    }

    public void addProduct(Product product) {
        if (product != null)
            products.add(product);
        else throw new IllegalArgumentException("Invalid product data");
    }

    public void removeProduct(Product product) {
        boolean notFound = true;
        if (product != null)
            for (int i = 0; i < products.size(); i++) {
                if (product.equals(products.get(i))) {
                    products.remove(i);
                    notFound = false;
                    break;
                }
            }
        else throw new IllegalArgumentException("Invalid product data");
        if (notFound) throw new IllegalArgumentException("Product not found");
    }

    //get
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public String print() {
        StringBuilder printOut = new StringBuilder();
        if (products.size() != MIN_CATEGORY_ELEMENT) {
            for (Product productName : products) {
                printOut.append(String.format("#Category: %s%n", this.name))
                        .append(String.format("%s", Product.print(productName)));
            }
        } else printOut.append(String.format("#Category: %s%n #No product in this category",
                this.name));
        return printOut.toString();
    }
}