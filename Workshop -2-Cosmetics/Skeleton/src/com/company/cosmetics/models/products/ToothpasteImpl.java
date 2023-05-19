package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.common.GenderType;


import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductBase implements Toothpaste {

    private List<String> ingredients;

    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name, brand, price, gender);
        setIngredients(ingredients);

    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public GenderType getGender() {
        return super.getGender();
    }

    @Override
    public String print() {
        String adultPrint = super.print();
        return String.format("%s\n #Ingredients: %s", adultPrint, ingredients);


    }

    public void setIngredients(List<String> ingredients) {
        if (ingredients == null) {
            throw new IllegalArgumentException("Ingredients cannot be null");
        }
        this.ingredients = new ArrayList<>();
    }


    @Override
    public List<String> getIngredients() {
        return this.ingredients;
    }
}
