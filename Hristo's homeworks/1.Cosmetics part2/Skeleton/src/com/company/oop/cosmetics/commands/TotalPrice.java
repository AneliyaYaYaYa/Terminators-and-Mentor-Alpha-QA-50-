package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsFactory;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.cart.ShoppingCart;

import java.util.List;

public class TotalPrice implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public TotalPrice(CosmeticsFactory cosmeticsFactory, CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsFactory = cosmeticsFactory;
        this.cosmeticsRepository = cosmeticsRepository;
    }
    
    @Override
    public String execute(List<String> parameters) {
        ShoppingCart cart = cosmeticsRepository.getShoppingCart();
        if (cart.getProductList().size() == 0) {
            return "No product in shopping cart!";
        }
        return String.format(CommandConstants.TOTAL_PRICE_IN_SHOPPING_CART, cart.totalPrice());
    }
    
}
