package com.company.oop.cosmetics.commands.contracts;

import java.util.List;

public interface Command {
    
    String execute(List<String> parameters);
    
}
