package com.company.oop.cosmetics.tests.models.shoppingcart;

import com.company.oop.cosmetics.models.cart.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Constructor_Should {
    
    @Test
    public void InitializeNewListOfProductsWhenCategoryIsCreated() {
        // Arrange, Act
        ShoppingCart cart = new ShoppingCart();
        
        // Assert
        Assertions.assertNotNull(cart.getProductList());
    }
    
}
