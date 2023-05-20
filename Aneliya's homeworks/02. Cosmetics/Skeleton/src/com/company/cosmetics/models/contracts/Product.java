package com.company.cosmetics.models.contracts;

import com.company.cosmetics.models.common.GenderType;

public interface Product {
    
    String getName();
    
    String getBrand();
    
    double getPrice();
    
    GenderType getGender();
    
    String print();
    
}
