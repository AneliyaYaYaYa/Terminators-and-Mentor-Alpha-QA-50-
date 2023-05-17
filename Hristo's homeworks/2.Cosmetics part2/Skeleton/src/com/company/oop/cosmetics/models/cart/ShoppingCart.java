package com.company.oop.cosmetics.models.cart;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public static final String NULL_ERROR_MESSAGE = "Product cannot be null.";
    private List<Product> productList;


    public ShoppingCart() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return new ArrayList<>(productList);  // need to return copies of the productList not address
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
        productList.add(product);
    }

    public void removeProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
        productList.remove(product);
    }

    public boolean containsProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
        return productList.contains(product);
    }


    public double totalPrice() {

        double totalPrice = 0.0;

        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;

    }
}
