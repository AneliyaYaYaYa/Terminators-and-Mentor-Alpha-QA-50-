package com.company.cosmetics.models.cart;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.contracts.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ShoppingCart {

    public static final String NULL_ERROR_MESSAGE = "Product cannot be null.";
    private List<Product> productList;
    
    public ShoppingCartImpl() {
        productList = new ArrayList<>();
    }
    
    public List<Product> getProductList() {
        return new ArrayList<>(productList);
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
