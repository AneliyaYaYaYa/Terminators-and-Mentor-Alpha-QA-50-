package com.company.cosmetics.tests.cosmeticsfactory;

import com.company.cosmetics.core.contracts.CosmeticsFactory;
import com.company.cosmetics.core.factories.CosmeticsFactoryImpl;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.contracts.Toothpaste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CreateToothpaste_Should {
    
    @Test
    public void returnInstanceOfTypeProduct() {
        // Arrange
        CosmeticsFactory factory = new CosmeticsFactoryImpl();
        // Act
        Toothpaste toothpaste = factory.createToothpaste("name", "brand", 10, GenderType.UNISEX, new ArrayList<>());
        // Assert
        Assertions.assertTrue(toothpaste instanceof Product);
    }
    
}
