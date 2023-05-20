package com.company.cosmetics.core.contracts;

import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.contracts.ShoppingCart;

import java.util.Map;

public interface CosmeticsRepository {
    
    public ShoppingCart getShoppingCart();
    
    public Map<String, Category> getCategories();
    
    public Map<String, Product> getProducts();
    
}
