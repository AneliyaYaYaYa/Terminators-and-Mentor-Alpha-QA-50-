package com.company.cosmetics.tests.cosmeticsfactory;

import com.company.cosmetics.core.contracts.CosmeticsFactory;
import com.company.cosmetics.core.factories.CosmeticsFactoryImpl;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;
import com.company.cosmetics.models.contracts.Cream;
import com.company.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateCream_Should {
    
    @Test
    public void returnInstanceOfTypeProduct() {
        // Arrange
        CosmeticsFactory factory = new CosmeticsFactoryImpl();
        // Act
        Cream cream = factory.createCream("name", "brand", 10, GenderType.UNISEX, ScentType.VANILLA);
        // Assert
        Assertions.assertTrue(cream instanceof Product);
    }
    
}