package com.company.cosmetics.models.contracts;

import com.company.cosmetics.models.common.UsageType;

public interface Shampoo extends Product {
    
    public int getMilliliters();
    
    public UsageType getUsage();
    
}
