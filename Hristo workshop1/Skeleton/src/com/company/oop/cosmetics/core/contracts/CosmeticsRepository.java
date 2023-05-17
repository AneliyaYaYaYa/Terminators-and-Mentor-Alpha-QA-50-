package com.company.oop.cosmetics.core.contracts;

import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.cart.ShoppingCart;
import com.company.oop.cosmetics.models.products.Product;

import java.util.Map;

public interface CosmeticsRepository {
    
    ShoppingCart getShoppingCart();
    
    Map<String, Category> getCategories();
    
    Map<String, Product> getProducts();
    
}
