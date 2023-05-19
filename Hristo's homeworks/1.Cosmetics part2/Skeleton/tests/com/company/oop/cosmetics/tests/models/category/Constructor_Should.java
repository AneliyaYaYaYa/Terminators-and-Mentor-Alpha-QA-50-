package com.company.oop.cosmetics.tests.models.category;

import com.company.oop.cosmetics.models.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Constructor_Should {
    
    @Test
    public void ThrowWhenTheNameIsSmallerThanMinValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("1"));
    }
    
    @Test
    public void ThrowWhenTheNameIsLargerThanMaxValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("1234567890123456"));
    }
    
    @Test
    public void CreateCategoryWhenNameIsValid() {
        // Arrange, Act
        Category category = new Category("test");
        
        // Assert
        Assertions.assertTrue(category instanceof Category);
    }
    
    @Test
    public void InitializeNewListOfProductsWhenCategoryIsCreated() {
        // Arrange, Act
        
        Category category = new Category("test");
        
        // Assert
        Assertions.assertNotNull(category.getProducts());
    }
    
}
