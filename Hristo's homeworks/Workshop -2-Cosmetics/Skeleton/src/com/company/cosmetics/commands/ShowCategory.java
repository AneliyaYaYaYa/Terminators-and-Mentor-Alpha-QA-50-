package com.company.cosmetics.commands;

import com.company.cosmetics.core.contracts.Command;
import com.company.cosmetics.core.contracts.CosmeticsFactory;
import com.company.cosmetics.core.contracts.CosmeticsRepository;
import com.company.cosmetics.models.contracts.Category;

import java.util.List;

public class ShowCategory implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public ShowCategory(CosmeticsRepository cosmeticsRepository, CosmeticsFactory cosmeticsFactory) {
        this.cosmeticsRepository = cosmeticsRepository;
        this.cosmeticsFactory = cosmeticsFactory;
    }
    
    @Override
    public String execute(List<String> parameters) {
        String categoryToShow = parameters.get(0);
        return showCategory(categoryToShow);
    }
    
    private String showCategory(String categoryToShow) {
        if (!cosmeticsRepository.getCategories().containsKey(categoryToShow)) {
            return String.format(CommandConstants.CATEGORY_DOES_NOT_EXIST, categoryToShow);
        }
        
        Category category = cosmeticsRepository.getCategories().get(categoryToShow);
        
        return category.print();
    }
    
    
}
