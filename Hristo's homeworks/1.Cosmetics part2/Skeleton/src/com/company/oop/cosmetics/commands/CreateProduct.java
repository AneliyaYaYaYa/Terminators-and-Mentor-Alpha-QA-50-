package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsFactory;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.products.Product;

import java.util.List;

public class CreateProduct implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public CreateProduct(CosmeticsFactory cosmeticsFactory, CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsFactory = cosmeticsFactory;
        this.cosmeticsRepository = cosmeticsRepository;
    }
    
    @Override
    public String execute(List<String> parameters) {
        String name = parameters.get(0);
        String brand = parameters.get(1);
        double price = Double.parseDouble(parameters.get(2));
        String gender = parameters.get(3);
        return createProduct(name, brand, price, gender);
    }
    
    private String createProduct(String name, String brand, double price, String gender) {
        if (cosmeticsRepository.getProducts().containsKey(name)) {
            return String.format(CommandConstants.PRODUCT_ALREADY_EXIST, name);
        }
        
        Product shampoo = cosmeticsFactory.createProduct(name, brand, price, gender);
        cosmeticsRepository.getProducts().put(name, shampoo);
        
        return String.format(CommandConstants.PRODUCT_CREATED, name);
    }
    
}
