package com.company.oop.cosmetics.tests.models.shoppingcart;

import com.company.oop.cosmetics.models.cart.ShoppingCart;
import com.company.oop.cosmetics.models.common.GenderType;
import com.company.oop.cosmetics.models.products.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainsProduct_Should {
    
    @Test
    public void ThrowWhenTheProductIsNull() {
        // Arrange, Act
        ShoppingCart cart = new ShoppingCart();
        
        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> cart.containsProduct(null));
    }
    
    @Test
    public void ReturnTrueWhenProductIFound() {
        // Arrange, Act
        ShoppingCart cart = new ShoppingCart();
        Product productToAdd = new Product("name", "brand", 10, GenderType.MEN);
        cart.addProduct(productToAdd);
        cart.addProduct(productToAdd);
        
        // Act
        boolean isFound = cart.containsProduct(productToAdd);
        
        //Assert
        Assertions.assertTrue(isFound);
    }
    
    @Test
    public void ReturnFalseWhenProductIFound() {
        // Arrange, Act
        ShoppingCart cart = new ShoppingCart();
        Product productToAdd = new Product("name", "brand", 10, GenderType.MEN);
        
        // Act
        boolean isFound = cart.containsProduct(productToAdd);
        
        //Assert
        Assertions.assertFalse(isFound);
    }
    
}
