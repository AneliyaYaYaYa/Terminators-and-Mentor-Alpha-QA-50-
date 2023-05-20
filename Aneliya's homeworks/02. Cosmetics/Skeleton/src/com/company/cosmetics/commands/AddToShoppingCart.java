package com.company.cosmetics.commands;

import com.company.cosmetics.core.contracts.Command;
import com.company.cosmetics.core.contracts.CosmeticsFactory;
import com.company.cosmetics.core.contracts.CosmeticsRepository;
import com.company.cosmetics.models.contracts.Product;

import java.util.List;

import static com.company.cosmetics.commands.CommandConstants.PRODUCT_ADDED_TO_SHOPPING_CART;
import static com.company.cosmetics.commands.CommandConstants.PRODUCT_DOES_NOT_EXIST;

public class AddToShoppingCart implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public AddToShoppingCart(CosmeticsRepository cosmeticsRepository, CosmeticsFactory cosmeticsFactory) {
        this.cosmeticsRepository = cosmeticsRepository;
        this.cosmeticsFactory = cosmeticsFactory;
    }
    
    @Override
    public String execute(List<String> parameters) {
        String productToAddToCart = parameters.get(0);
        return addToShoppingCart(productToAddToCart);
    }
    
    private String addToShoppingCart(String productName) {
        if (!cosmeticsRepository.getProducts().containsKey(productName)) {
            return String.format(PRODUCT_DOES_NOT_EXIST, productName);
        }
        
        Product product = cosmeticsRepository.getProducts().get(productName);
        cosmeticsRepository.getShoppingCart().addProduct(product);
        
        return String.format(PRODUCT_ADDED_TO_SHOPPING_CART, productName);
    }
    
}
