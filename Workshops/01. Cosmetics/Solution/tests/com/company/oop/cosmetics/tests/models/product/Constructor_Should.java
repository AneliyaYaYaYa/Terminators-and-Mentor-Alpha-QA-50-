package com.company.oop.cosmetics.tests.models.product;

import com.company.oop.cosmetics.models.common.GenderType;
import com.company.oop.cosmetics.models.products.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Constructor_Should {
    
    @Test
    public void ThrowWhenTheNameIsSmallerThanMinValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Product("1", "brand", 10, GenderType.MEN));
    }
    
    @Test
    public void ThrowWhenTheNameIsLargerThanMaxValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Product("12345678901", "brand", 10, GenderType.MEN));
    }
    
    @Test
    public void ThrowWhenTheBrandIsSmallerThanMinValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Product("name", "b", 10, GenderType.MEN));
    }
    
    @Test
    public void ThrowWhenTheBrandIsLargerThanMaxValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Product("name", "12345678901", 10, GenderType.MEN));
    }
    
    @Test
    public void ThrowWhenPriceIsNegative() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Product("name", "brand", -1, GenderType.MEN));
    }
    
    @Test
    public void CreateProductWhenValidValuesArePassed() {
        // Arrange, Act
        Product product = new Product("name", "brand", 10, GenderType.MEN);
        
        // Assert
        Assertions.assertTrue(product instanceof Product);
    }
    
}