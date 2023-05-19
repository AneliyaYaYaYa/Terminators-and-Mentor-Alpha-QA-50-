package com.company.oop.cosmetics.core.contracts;

import java.util.List;

public interface Parser {
    
    String parseCommand(String fullCommand);
    
    List<String> parseParameters(String fullCommand);
    
}
