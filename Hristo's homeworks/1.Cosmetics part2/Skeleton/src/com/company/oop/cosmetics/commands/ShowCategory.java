package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsFactory;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.Category;

import java.util.List;

public class ShowCategory implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public ShowCategory(CosmeticsFactory cosmeticsFactory, CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsFactory = cosmeticsFactory;
        this.cosmeticsRepository = cosmeticsRepository;
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
