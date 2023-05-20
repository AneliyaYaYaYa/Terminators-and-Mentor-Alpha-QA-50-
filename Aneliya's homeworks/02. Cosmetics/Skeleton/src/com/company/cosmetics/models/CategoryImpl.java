package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.products.ProductBase;


import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    public static final String NAME_NULL_ERROR = "Name cannot be null.";
    
    private String name;
    private List<Product> products;
    
    public CategoryImpl(String name) {
        setName(name);
        this.products = new ArrayList<>();

    }

    private void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(NAME_NULL_ERROR);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public List<Product> getProducts() {
        // we dont want anyone to be able to change anything in the original list once it is created,
        // so we present to the person who calls it just a copy of the original list
        // todo why are we returning a copy? Replace this comment with explanation!
        return new ArrayList<>(products);
    }
    
    public void addProduct(Product product) {
        products.add(product);
    }
    
    public void removeProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
        }
        throw new IllegalArgumentException("This products is not in the Products' list.");
    }
    
    //The engine calls this method to print your category! You should not rename it!
    public String print() {
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        }
        return String.format("Product %s added to category %s!",getName(), getName());
    }
    
}
