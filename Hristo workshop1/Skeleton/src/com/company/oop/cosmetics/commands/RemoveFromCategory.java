package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsFactory;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.products.Product;

import java.util.List;

public class RemoveFromCategory implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public RemoveFromCategory(CosmeticsFactory cosmeticsFactory, CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsFactory = cosmeticsFactory;
        this.cosmeticsRepository = cosmeticsRepository;
    }
    
    @Override
    public String execute(List<String> parameters) {
        String categoryNameToRemove = parameters.get(0);
        String productToRemove = parameters.get(1);
        return removeCategory(categoryNameToRemove, productToRemove);
    }
    
    private String removeCategory(String categoryNameToRemove, String productToRemove) {
        if (!cosmeticsRepository.getCategories().containsKey(categoryNameToRemove)) {
            return String.format(CommandConstants.CATEGORY_DOES_NOT_EXIST, categoryNameToRemove);
        }
        
        if (!cosmeticsRepository.getProducts().containsKey(productToRemove)) {
            return String.format(CommandConstants.PRODUCT_DOES_NOT_EXIST, productToRemove);
        }
        
        Category category = cosmeticsRepository.getCategories().get(categoryNameToRemove);
        Product product = cosmeticsRepository.getProducts().get(productToRemove);
        
        category.removeProduct(product);
        
        return String.format(CommandConstants.PRODUCT_REMOVED_CATEGORY, productToRemove, categoryNameToRemove);
    }
    
}
