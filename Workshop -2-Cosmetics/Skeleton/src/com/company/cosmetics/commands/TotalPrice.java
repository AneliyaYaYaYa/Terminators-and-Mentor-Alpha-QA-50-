package com.company.cosmetics.commands;

import com.company.cosmetics.core.contracts.Command;
import com.company.cosmetics.core.contracts.CosmeticsFactory;
import com.company.cosmetics.core.contracts.CosmeticsRepository;
import com.company.cosmetics.models.contracts.ShoppingCart;

import java.util.List;

import static com.company.cosmetics.commands.CommandConstants.TOTAL_PRICE_IN_SHOPPING_CART;

public class TotalPrice implements Command {
    
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;
    
    public TotalPrice(CosmeticsRepository cosmeticsRepository, CosmeticsFactory cosmeticsFactory) {
        this.cosmeticsRepository = cosmeticsRepository;
        this.cosmeticsFactory = cosmeticsFactory;
    }
    
    @Override
    public String execute(List<String> parameters) {
        ShoppingCart shoppingCart = cosmeticsRepository.getShoppingCart();
        return shoppingCart.getProductList() != null && shoppingCart.getProductList().size() > 0 ?
                String.format(TOTAL_PRICE_IN_SHOPPING_CART, shoppingCart.totalPrice()) :
                "No product in shopping cart!";
    }
    
}
