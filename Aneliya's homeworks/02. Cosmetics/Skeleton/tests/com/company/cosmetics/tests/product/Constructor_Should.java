package com.company.cosmetics.tests.product;

import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;
import com.company.cosmetics.models.common.UsageType;
import com.company.cosmetics.models.products.CreamImpl;
import com.company.cosmetics.models.products.ShampooImpl;
import com.company.cosmetics.models.products.ToothpasteImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Constructor_Should {
    
    @Test
    public void throwWhenTheNameIsNull() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ShampooImpl(null, "brand", 10, GenderType.MEN, 10, UsageType.EVERYDAY));
    }
    
    @Test
    public void throwWhenTheBrandIsNull() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ShampooImpl("name", null, 10, GenderType.MEN, 10, UsageType.EVERYDAY));
    }
    
    @Test
    public void throwWhenTheNameIsSmallerThanMinValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ShampooImpl("n", "brand", 10, GenderType.MEN, 10, UsageType.EVERYDAY));
    }
    
    @Test
    public void throwWhenTheNameIsLargerThanMaxValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ShampooImpl("01234567890", "brand", 10, GenderType.MEN, 10, UsageType.EVERYDAY));
    }
    
    @Test
    public void throwWhenTheBrandIsSmallerThanMinValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ShampooImpl("name", "b", 10, GenderType.MEN, 10, UsageType.EVERYDAY));
    }
    
    @Test
    public void throwWhenTheBrandIsLargerThanMaxValue() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ShampooImpl("name", "01234567890", 10, GenderType.MEN, 10, UsageType.EVERYDAY));
    }
    
    @Test
    public void throwWhenPriceIsNegative() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ShampooImpl("name", "brand", -1, GenderType.MEN, 10, UsageType.EVERYDAY));
    }
    
    @Test
    public void createShampooWhenValidValuesArePassed() {
        // Arrange, Act, Assert
        ShampooImpl shampoo = new ShampooImpl("name", "brand", 10, GenderType.MEN, 10, UsageType.EVERYDAY);
    }
    
    @Test
    public void throwWhenNullIngredientsArePassed() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ToothpasteImpl("name", "brand", 10, GenderType.WOMEN, null));
    }
    
    @Test
    public void createToothpasteWhenValidValuesArePassed() {
        // Arrange, Act, Assert
        ToothpasteImpl shampoo = new ToothpasteImpl("name", "brand", 10, GenderType.WOMEN, new ArrayList<>());
    }
    
    @Test
    public void createCreamWhenValidValuesArePassed() {
        // Arrange, Act, Assert
        CreamImpl cream = new CreamImpl("name", "brand", 10, GenderType.WOMEN, ScentType.ROSE);
    }
    
}