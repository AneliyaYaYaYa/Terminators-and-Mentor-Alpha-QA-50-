package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.common.GenderType;


import java.util.List;

public class ToothpasteImpl extends ProductBase implements Toothpaste {

    private List<String> ingredients;
    
    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name, brand, price, gender);
        setIngredients(ingredients);
    }


    private void setIngredients(List<String> ingredients) {
        if (ingredients == null) {
            throw new IllegalArgumentException("Ingredients cannot be null.");
        }
        this.ingredients = ingredients;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not implemented yet. ToothpasteImpl class");
    }

    @Override
    public String getBrand() {
        throw new UnsupportedOperationException("Not implemented yet. ToothpasteImpl class");
    }

    @Override
    public double getPrice() {
        throw new UnsupportedOperationException("Not implemented yet. ToothpasteImpl class");
    }

    @Override
    public GenderType getGender() {
        throw new UnsupportedOperationException("Not implemented yet. ToothpasteImpl class");
    }

    @Override
    public String print() {
        throw new UnsupportedOperationException("Not implemented yet. ToothpasteImpl class");
    }

    @Override
    public List<String> getIngredients() {
        throw new UnsupportedOperationException("Not implemented yet. ToothpasteImpl class");
    }
}
