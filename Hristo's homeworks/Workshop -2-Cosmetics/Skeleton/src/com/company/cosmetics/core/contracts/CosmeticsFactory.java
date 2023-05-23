package com.company.cosmetics.core.contracts;

import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;
import com.company.cosmetics.models.common.UsageType;
import com.company.cosmetics.models.contracts.*;

import java.util.List;

public interface CosmeticsFactory {
    
    Category createCategory(String name);
    
    Shampoo createShampoo(String name, String brand, double price, GenderType gender, int milliliters, UsageType usage);
    
    Toothpaste createToothpaste(String name, String brand, double price, GenderType gender, List<String> ingredients);
    
    Cream createCream(String name, String brand, double price, GenderType gender, ScentType scent);
    
    ShoppingCart createShoppingCart();
    
}
