package com.company.oop.cosmetics.tests.models.category;

import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.common.GenderType;
import com.company.oop.cosmetics.models.products.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddProduct_Should {
    
    @Test
    public void ThrowWhenTheProductIsNull() {
        // Arrange, Act
        Category category = new Category("test");
        
        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> category.addProduct(null));
    }
    
    @Test
    public void AddProductWhenProductIsValid() {
        // Arrange
        Category category = new Category("test");
        Product productToAdd = new Product("name", "brand", 10, GenderType.MEN);
        
        // Act
        category.addProduct(productToAdd);
        category.addProduct(productToAdd);
        
        //Assert
        Assertions.assertEquals(2, category.getProducts().size());
    }
    
}

