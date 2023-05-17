package com.company.oop.cosmetics.core.factories;

import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.cart.ShoppingCart;
import com.company.oop.cosmetics.models.common.GenderType;
import com.company.oop.cosmetics.models.products.Product;
import com.company.oop.cosmetics.core.contracts.CosmeticsFactory;

public class CosmeticsFactoryImpl implements CosmeticsFactory {
    
    public Category createCategory(String name) {
        return new Category(name);
    }
    
    public Product createProduct(String name, String brand, double price, String gender) {
//        GenderType genderEnum = GenderType.valueOf(gender);
//        Product product = new Product(name, brand, price, genderEnum);//bez tova
//        return new Product(name, brand, price, genderEnum);
        return new Product(name, brand, price, GenderType.valueOf(gender.toUpperCase()));
    }
    
    public ShoppingCart createShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        return new ShoppingCart();
    }
    
}
