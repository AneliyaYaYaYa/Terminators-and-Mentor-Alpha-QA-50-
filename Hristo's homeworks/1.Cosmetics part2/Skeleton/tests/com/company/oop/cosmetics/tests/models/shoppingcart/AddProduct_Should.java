package com.company.oop.cosmetics.tests.models.shoppingcart;

import com.company.oop.cosmetics.models.cart.ShoppingCart;
import com.company.oop.cosmetics.models.common.GenderType;
import com.company.oop.cosmetics.models.products.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddProduct_Should {
    
    @Test
    public void ThrowWhenTheProductIsNull() {
        // Arrange, Act
        ShoppingCart cart = new ShoppingCart();
        
        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> cart.addProduct(null));
    }
    
    @Test
    public void AddProductWhenProductIsValid() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        // Arrange, Act
        Product productToAdd = new Product("name", "brand", 10, GenderType.MEN);
        
        // Act
        cart.addProduct(productToAdd);
        cart.addProduct(productToAdd);
        
        //Assert
        Assertions.assertEquals(2, cart.getProductList().size());
    }
    
}
