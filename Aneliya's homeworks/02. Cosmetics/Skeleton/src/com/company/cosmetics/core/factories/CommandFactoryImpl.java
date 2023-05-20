package com.company.cosmetics.core.factories;

import com.company.cosmetics.commands.*;
import com.company.cosmetics.commands.enums.CommandType;
import com.company.cosmetics.core.contracts.Command;
import com.company.cosmetics.core.contracts.CommandFactory;
import com.company.cosmetics.core.contracts.CosmeticsFactory;
import com.company.cosmetics.core.contracts.CosmeticsRepository;

public class CommandFactoryImpl implements CommandFactory {
    
    private static final String INVALID_COMMAND = "Invalid command name: %s!";
    
    @Override
    public Command createCommand(String commandTypeAsString, CosmeticsFactory cosmeticsFactory, CosmeticsRepository cosmeticsRepository) {
        CommandType commandType = CommandType.valueOf(commandTypeAsString.toUpperCase());
        
        switch (commandType) {
            case REMOVEFROMSHOPPINGCART:
                return new RemoveFromShoppingCart(cosmeticsRepository, cosmeticsFactory);
            case ADDTOSHOPPINGCART:
                return new AddToShoppingCart(cosmeticsRepository, cosmeticsFactory);
            case ADDTOCATEGORY:
                return new AddToCategory(cosmeticsRepository, cosmeticsFactory);
            case SHOWCATEGORY:
                return new ShowCategory(cosmeticsRepository, cosmeticsFactory);
            case CREATECREAM:
                return new CreateCream(cosmeticsRepository, cosmeticsFactory);
            case TOTALPRICE:
                return new TotalPrice(cosmeticsRepository, cosmeticsFactory);
            case CREATESHAMPOO:
                return new CreateShampoo(cosmeticsRepository, cosmeticsFactory);
            case CREATETOOTHPASTE:
                return new CreateToothpaste(cosmeticsRepository, cosmeticsFactory);
            case CREATECATEGORY:
                return new CreateCategory(cosmeticsRepository, cosmeticsFactory);
            case REMOVEFROMCATEGORY:
                return new RemoveFromCategory(cosmeticsRepository, cosmeticsFactory);
        }
        throw new IllegalArgumentException(String.format(INVALID_COMMAND, commandTypeAsString));
    }
    
}
