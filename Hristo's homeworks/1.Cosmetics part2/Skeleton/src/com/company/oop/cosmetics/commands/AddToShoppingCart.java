package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsFactory;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.products.Product;

import java.util.List;

public class AddToShoppingCart implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public AddToShoppingCart(CosmeticsFactory cosmeticsFactory, CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsFactory = cosmeticsFactory;
        this.cosmeticsRepository = cosmeticsRepository;
    }
    
    @Override
    public String execute(List<String> parameters) {
        String productToAddToCart = parameters.get(0);
        return addToShoppingCart(productToAddToCart);
    }
    
    private String addToShoppingCart(String productName) {
        if (!cosmeticsRepository.getProducts().containsKey(productName)) {
            return String.format(CommandConstants.PRODUCT_DOES_NOT_EXIST, productName);
        }
        
        Product product = cosmeticsRepository.getProducts().get(productName);
        cosmeticsRepository.getShoppingCart().addProduct(product);
        
        return String.format(CommandConstants.PRODUCT_ADDED_TO_SHOPPING_CART, productName);
    }
    
}
