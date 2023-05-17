package com.company.oop.cosmetics.core.factories;

import com.company.oop.cosmetics.commands.*;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.commands.enums.CommandType;
import com.company.oop.cosmetics.core.contracts.CommandFactory;
import com.company.oop.cosmetics.core.contracts.CosmeticsFactory;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;

public class CommandFactoryImpl implements CommandFactory {
    
    private static final String INVALID_COMMAND = "Invalid command name: %s!";
    
    @Override
    public Command createCommand(String commandTypeAsString, CosmeticsFactory cosmeticsFactory, CosmeticsRepository cosmeticsRepository) {
        CommandType commandType = CommandType.valueOf(commandTypeAsString.toUpperCase());
        switch (commandType) {
            case CREATECATEGORY:
                return new CreateCategory(cosmeticsFactory, cosmeticsRepository);
            case TOTALPRICE:
                return new TotalPrice(cosmeticsFactory, cosmeticsRepository);
            case SHOWCATEGORY:
                return new ShowCategory(cosmeticsFactory, cosmeticsRepository);
            case ADDTOCATEGORY:
                return new AddToCategory(cosmeticsFactory, cosmeticsRepository);
            case CREATEPRODUCT:
                return new CreateProduct(cosmeticsFactory, cosmeticsRepository);
            case ADDTOSHOPPINGCART:
                return new AddToShoppingCart(cosmeticsFactory, cosmeticsRepository);
            case REMOVEFROMSHOPPINGCART:
                return new RemoveFromShoppingCart(cosmeticsFactory, cosmeticsRepository);
            case REMOVEFROMCATEGORY:
                return new RemoveFromCategory(cosmeticsFactory, cosmeticsRepository);
            default:
                throw new IllegalArgumentException(String.format(INVALID_COMMAND, commandTypeAsString));
        }
        
    }
    
}
