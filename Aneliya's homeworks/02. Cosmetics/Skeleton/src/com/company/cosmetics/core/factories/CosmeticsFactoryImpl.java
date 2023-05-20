package com.company.cosmetics.core.factories;

import com.company.cosmetics.models.CategoryImpl;
import com.company.cosmetics.models.cart.ShoppingCartImpl;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;
import com.company.cosmetics.models.common.UsageType;
import com.company.cosmetics.models.contracts.*;
import com.company.cosmetics.models.products.CreamImpl;
import com.company.cosmetics.models.products.ShampooImpl;
import com.company.cosmetics.models.products.ToothpasteImpl;
import com.company.cosmetics.core.contracts.CosmeticsFactory;

import java.util.List;

public class CosmeticsFactoryImpl implements CosmeticsFactory {
    
    @Override
    public Category createCategory(String name) {
        return new CategoryImpl(name);
    }
    
    @Override
    public Shampoo createShampoo(String name, String brand, double price, GenderType gender, int milliliters, UsageType usage) {
        return new ShampooImpl(name, brand, price, gender, milliliters, usage);
    }
    
    @Override
    public Toothpaste createToothpaste(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        return new ToothpasteImpl(name, brand, price, gender, ingredients);
    }
    
    @Override
    public Cream createCream(String name, String brand, double price, GenderType gender, ScentType scent) {
        return new CreamImpl(name, brand, price, gender, scent);
    }
    
    @Override
    public ShoppingCart createShoppingCart() {
        return new ShoppingCartImpl();
    }
    
}
