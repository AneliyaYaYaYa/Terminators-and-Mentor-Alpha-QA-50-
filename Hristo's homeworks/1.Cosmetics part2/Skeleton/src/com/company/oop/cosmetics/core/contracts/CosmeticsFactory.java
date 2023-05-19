package com.company.oop.cosmetics.core.contracts;

import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.cart.ShoppingCart;
import com.company.oop.cosmetics.models.products.Product;

public interface CosmeticsFactory {
    
    Category createCategory(String name);
    
    Product createProduct(String name, String brand, double price, String gender);
    
    ShoppingCart createShoppingCart();
    
}