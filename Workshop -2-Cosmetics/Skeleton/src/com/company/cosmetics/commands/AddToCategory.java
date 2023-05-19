package com.company.cosmetics.commands;

import com.company.cosmetics.core.contracts.Command;
import com.company.cosmetics.core.contracts.CosmeticsFactory;
import com.company.cosmetics.core.contracts.CosmeticsRepository;
import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;

import java.util.List;

public class AddToCategory implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public AddToCategory(CosmeticsRepository cosmeticsRepository, CosmeticsFactory cosmeticsFactory) {
        this.cosmeticsRepository = cosmeticsRepository;
        this.cosmeticsFactory = cosmeticsFactory;
    }
    
    @Override
    public String execute(List<String> parameters) {
        String categoryNameToAdd = parameters.get(0);
        String productToAdd = parameters.get(1);
        return addToCategory(categoryNameToAdd, productToAdd);
    }
    
    private String addToCategory(String categoryNameToAdd, String productToAdd) {
        if (!cosmeticsRepository.getCategories().containsKey(categoryNameToAdd)) {
            return String.format(CommandConstants.CATEGORY_DOES_NOT_EXIST, categoryNameToAdd);
        }
        
        if (!cosmeticsRepository.getProducts().containsKey(productToAdd)) {
            return String.format(CommandConstants.PRODUCT_DOES_NOT_EXIST, productToAdd);
        }
        
        Category category = cosmeticsRepository.getCategories().get(categoryNameToAdd);
        Product product = cosmeticsRepository.getProducts().get(productToAdd);
        
        category.addProduct(product);
        
        return String.format(CommandConstants.PRODUCT_ADDED_TO_CATEGORY, productToAdd, categoryNameToAdd);
    }
    
}
