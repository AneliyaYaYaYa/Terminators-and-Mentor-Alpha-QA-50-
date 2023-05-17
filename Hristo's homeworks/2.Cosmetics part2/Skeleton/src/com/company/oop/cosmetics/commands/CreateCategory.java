package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsFactory;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.Category;

import java.util.List;

import static com.company.oop.cosmetics.commands.CommandConstants.CATEGORY_CREATED;
import static com.company.oop.cosmetics.commands.CommandConstants.CATEGORY_EXISTS;

public class CreateCategory implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public CreateCategory(CosmeticsFactory cosmeticsFactory, CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsFactory = cosmeticsFactory;
        this.cosmeticsRepository = cosmeticsRepository;
    }
    
    @Override
    public String execute(List<String> parameters) {
        String categoryName = parameters.get(0);
        return createCategory(categoryName);
    }
    
    private String createCategory(String categoryName) {
        if (cosmeticsRepository.getCategories().containsKey(categoryName)) {
            return String.format(CATEGORY_EXISTS, categoryName);
        }
        
        Category category = cosmeticsFactory.createCategory(categoryName);
        cosmeticsRepository.getCategories().put(categoryName, category);
        
        return String.format(CATEGORY_CREATED, categoryName);
    }
    
}
