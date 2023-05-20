package com.company.cosmetics.commands;

import com.company.cosmetics.core.contracts.Command;
import com.company.cosmetics.core.contracts.CosmeticsFactory;
import com.company.cosmetics.core.contracts.CosmeticsRepository;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;
import com.company.cosmetics.models.contracts.Shampoo;

import java.util.List;

public class CreateShampoo implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public CreateShampoo(CosmeticsRepository cosmeticsRepository, CosmeticsFactory cosmeticsFactory) {
        this.cosmeticsRepository = cosmeticsRepository;
        this.cosmeticsFactory = cosmeticsFactory;
    }
    
    @Override
    public String execute(List<String> parameters) {
        String shampooName = parameters.get(0);
        String shampooBrand = parameters.get(1);
        double shampooPrice = Double.parseDouble(parameters.get(2));
        GenderType shampooGender = GenderType.valueOf(parameters.get(3).toUpperCase());
        int shampooMilliliters = Integer.parseInt(parameters.get(4));
        UsageType shampooUsage = UsageType.valueOf(parameters.get(5).toUpperCase());
        return createShampoo(shampooName, shampooBrand, shampooPrice, shampooGender, shampooMilliliters, shampooUsage);
    }
    
    private String createShampoo(String shampooName, String shampooBrand, double shampooPrice, GenderType shampooGender, int shampooMilliliters, UsageType shampooUsage) {
        if (cosmeticsRepository.getProducts().containsKey(shampooName)) {
            return String.format(CommandConstants.SHAMPOO_ALREADY_EXIST, shampooName);
        }
        
        Shampoo shampoo = cosmeticsFactory.createShampoo(shampooName, shampooBrand, shampooPrice, shampooGender, shampooMilliliters, shampooUsage);
        cosmeticsRepository.getProducts().put(shampooName, shampoo);
        
        return String.format(CommandConstants.SHAMPOO_CREATED, shampooName);
    }
    
}
