package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.cart.ShoppingCart;
import com.company.oop.cosmetics.models.products.Product;

import java.util.HashMap;
import java.util.Map;

public class CosmeticsRepositoryImpl implements CosmeticsRepository {
    
    private final ShoppingCart shoppingCart;
    private final Map<String, Category> categories;
    private final Map<String, Product> products;
    
    public CosmeticsRepositoryImpl() {
        shoppingCart = new ShoppingCart();
        categories = new HashMap<>();
        products = new HashMap<>();
    }
    
    @Override
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
    
    @Override
    public Map<String, Category> getCategories() {
        return categories;
    }
    
    @Override
    public Map<String, Product> getProducts() {
        return products;
    }
    
}
