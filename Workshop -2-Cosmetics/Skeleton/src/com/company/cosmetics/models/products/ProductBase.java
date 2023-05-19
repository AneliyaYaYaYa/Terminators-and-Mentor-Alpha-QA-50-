package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;


public class ProductBase implements Product {
    //Finish the class
    //What variables, what constants should you write here?
    //validate
    
    ProductBase() {
        throw new UnsupportedOperationException("Not implemented yet. ProductBase class");
        //this.gender = gender;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not implemented yet. ProductBase class");
    }

    @Override
    public String getBrand() {
        throw new UnsupportedOperationException("Not implemented yet. ProductBase class");
    }

    @Override
    public double getPrice() {
        throw new UnsupportedOperationException("Not implemented yet. ProductBase class");
    }

    @Override
    public GenderType getGender() {
        throw new UnsupportedOperationException("Not implemented yet. ProductBase class");
    }

    @Override
    public String print() {
        throw new UnsupportedOperationException("Not implemented yet. ProductBase class");
    }
}
