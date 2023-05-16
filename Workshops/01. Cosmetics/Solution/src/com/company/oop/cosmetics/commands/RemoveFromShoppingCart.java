package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsFactory;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.products.Product;

import java.util.List;

public class RemoveFromShoppingCart implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public RemoveFromShoppingCart(CosmeticsFactory cosmeticsFactory, CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsFactory = cosmeticsFactory;
        this.cosmeticsRepository = cosmeticsRepository;
    }
    
    @Override
    public String execute(List<String> parameters) {
        String productToRemoveFromCart = parameters.get(0);
        return removeFromShoppingCart(productToRemoveFromCart);
    }
    
    private String removeFromShoppingCart(String productName) {
        if (!cosmeticsRepository.getProducts().containsKey(productName)) {
            return String.format(CommandConstants.PRODUCT_DOES_NOT_EXIST, productName);
        }
        
        Product product = cosmeticsRepository.getProducts().get(productName);
        
        if (!cosmeticsRepository.getShoppingCart().containsProduct(product)) {
            return String.format(CommandConstants.PRODUCT_DOES_NOT_EXIST_IN_SHOPPING_CART, productName);
        }
        
        cosmeticsRepository.getShoppingCart().removeProduct(product);
        
        return String.format(CommandConstants.PRODUCT_REMOVED_FROM_SHOPPING_CART, productName);
    }
    
}
