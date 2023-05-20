package com.company.cosmetics.commands;

import com.company.cosmetics.core.contracts.Command;
import com.company.cosmetics.core.contracts.CosmeticsFactory;
import com.company.cosmetics.core.contracts.CosmeticsRepository;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.contracts.Toothpaste;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateToothpaste implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public CreateToothpaste(CosmeticsRepository cosmeticsRepository, CosmeticsFactory cosmeticsFactory) {
        this.cosmeticsRepository = cosmeticsRepository;
        this.cosmeticsFactory = cosmeticsFactory;
    }
    
    @Override
    public String execute(List<String> parameters) {
        String toothpasteName = parameters.get(0);
        String toothpasteBrand = parameters.get(1);
        double toothpastePrice = Double.parseDouble(parameters.get(2));
        GenderType toothpasteGender = GenderType.valueOf(parameters.get(3).toUpperCase());
        List<String> toothpasteIngredients = Arrays.stream(parameters.get(4).trim().split(",")).collect(Collectors.toList());
        return createToothpaste(toothpasteName, toothpasteBrand, toothpastePrice, toothpasteGender, toothpasteIngredients);
    }
    
    private String createToothpaste(String toothpasteName, String toothpasteBrand, double toothpastePrice, GenderType toothpasteGender, List<String> toothpasteIngredients) {
        if (cosmeticsRepository.getProducts().containsKey(toothpasteName)) {
            return String.format(CommandConstants.TOOTHPASTE_ALREADY_EXIST, toothpasteName);
        }
        
        Toothpaste toothpaste = cosmeticsFactory.createToothpaste(toothpasteName, toothpasteBrand, toothpastePrice, toothpasteGender, toothpasteIngredients);
        cosmeticsRepository.getProducts().put(toothpasteName, toothpaste);
        
        return String.format(CommandConstants.TOOTHPASTE_CREATED, toothpasteName);
    }
    
}
