package com.company.oop.cosmetics.tests.models.category;

import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.common.GenderType;
import com.company.oop.cosmetics.models.products.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveProduct_Should {
    
    @Test
    public void ThrowWhenTheProductIsNull() {
        // Arrange, Act
        Category category = new Category("test");
        
        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> category.removeProduct(null));
    }
    
    @Test
    public void RemoveProductWhenProductIsValid() {
        // Arrange, Act
        Category category = new Category("name");
        Product productToRemove = new Product("name", "brand", 10, GenderType.MEN);
        category.addProduct(productToRemove);
        category.addProduct(productToRemove);
        
        // Act
        category.removeProduct(productToRemove);
        
        //Assert
        Assertions.assertEquals(1, category.getProducts().size());
    }
    
    @Test
    public void ThrowWhenProductNotFound() {
        // Arrange, Act
        Category category = new Category("name");
        Product productToRemove = new Product("name", "brand", 10, GenderType.MEN);
        
        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> category.removeProduct(productToRemove));
    }
    
}
