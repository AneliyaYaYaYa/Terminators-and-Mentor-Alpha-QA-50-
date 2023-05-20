package com.company.cosmetics.commands;

import com.company.cosmetics.core.contracts.Command;
import com.company.cosmetics.core.contracts.CosmeticsFactory;
import com.company.cosmetics.core.contracts.CosmeticsRepository;
import com.company.cosmetics.models.contracts.Category;

import java.util.List;

public class CreateCategory implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public CreateCategory(CosmeticsRepository cosmeticsRepository, CosmeticsFactory cosmeticsFactory) {
        this.cosmeticsRepository = cosmeticsRepository;
        this.cosmeticsFactory = cosmeticsFactory;
    }
    
    @Override
    public String execute(List<String> parameters) {
        String categoryName = parameters.get(0);
        return createCategory(categoryName);
    }
    
    private String createCategory(String categoryName) {
        if (cosmeticsRepository.getCategories().containsKey(categoryName)) {
            return String.format(CommandConstants.CATEGORY_EXISTS, categoryName);
        }
        
        Category category = cosmeticsFactory.createCategory(categoryName);
        cosmeticsRepository.getCategories().put(categoryName, category);
        
        return String.format(CommandConstants.CATEGORY_CREATED, categoryName);
    }
    
}
