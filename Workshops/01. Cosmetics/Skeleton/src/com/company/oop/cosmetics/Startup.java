package com.company.oop.cosmetics;
import com.company.oop.cosmetics.core.CosmeticsEngine;
import com.company.oop.cosmetics.models.common.GenderType;
import com.company.oop.cosmetics.models.products.Product;

public class Startup {
    
    public static void main(String[] args) {
        CosmeticsEngine engine = new CosmeticsEngine();
        engine.start();
    }
}
