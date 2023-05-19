package com.company.cosmetics.core.contracts;

import java.util.List;

public interface Command {
    
    String execute(List<String> parameters);
    
}
