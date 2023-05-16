package com.company.oop.cosmetics.models.cart;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    
    private final List<Product> productList;
    
    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }
    
    public List<Product> getProductList() {
        return new ArrayList<>(productList);
    }
    
    public void addProduct(Product product) {
        if (product != null)
            productList.add(product);
        else throw new IllegalArgumentException("Invalid product");
    }
    
    public void removeProduct(Product product) {
        boolean notFound = true;
        for (int i = 0; i < productList.size(); i++) {
            if (product.equals(productList.get(i))) {
                productList.remove(i);
                notFound = false;
                break;
            }
        }
        if (notFound) throw new IllegalArgumentException("Product not found");
    }
    
    public boolean containsProduct(Product product) {
        boolean isContained = false;
        if (product == null) throw new IllegalArgumentException("Invalid product");
        for (Product prod:productList) {
            if (product.equals(prod)){
                isContained = true;
                break;
            }
        }
        return isContained;
    }
    
    public double totalPrice() {
        double price = 0;
        for (Product product : productList) {
        price += product.getPrice();
        }
        return price;
    }
}