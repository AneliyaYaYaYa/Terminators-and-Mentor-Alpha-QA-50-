package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;


import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    //use constants for validations values
    
    private String name;
    private List<Product> products;
    
    public CategoryImpl(String name) {
        //validate
        //initialize the collection
    }
    
    public String getName() {
        return name;
    }
    
    public List<Product> getProducts() {
        //todo why are we returning a copy? Replace this comment with explanation!
        return new ArrayList<>(products);
    }
    
    public void addProduct(Product product) {
        throw new UnsupportedOperationException("Not implemented yet. CategoryImpl Class");
    }
    
    public void removeProduct(Product product) {
        //validate
        throw new UnsupportedOperationException("Not implemented yet. CategoryImpl Class");
    }
    
    //The engine calls this method to print your category! You should not rename it!
    public String print() {
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        }
        //finish ProductBase class before implementing this method

        throw new UnsupportedOperationException("Not implemented yet. CategoryImpl Class");
    }
    
}
