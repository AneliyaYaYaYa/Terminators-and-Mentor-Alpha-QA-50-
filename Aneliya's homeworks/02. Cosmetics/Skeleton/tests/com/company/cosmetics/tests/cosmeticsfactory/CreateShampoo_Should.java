package com.company.cosmetics.tests.cosmeticsfactory;

import com.company.cosmetics.core.contracts.CosmeticsFactory;
import com.company.cosmetics.core.factories.CosmeticsFactoryImpl;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;
import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.contracts.Shampoo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateShampoo_Should {
    
    @Test
    public void returnInstanceOfTypeProduct() {
        // Arrange
        CosmeticsFactory factory = new CosmeticsFactoryImpl();
        // Act
        Shampoo shampoo = factory.createShampoo("name", "brand", 10, GenderType.UNISEX, 10, UsageType.EVERYDAY);
        // Assert
        Assertions.assertTrue(shampoo instanceof Product);
    }
    
}
