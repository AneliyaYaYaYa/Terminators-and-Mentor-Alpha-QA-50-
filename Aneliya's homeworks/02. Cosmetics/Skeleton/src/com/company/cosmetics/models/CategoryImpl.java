package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;


import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    private static final String NAME_NULL_ERROR = "Name cannot be null.";
    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 15;
    private static final String NAME_LENGTH_ERROR = String.format(
            "Name's length must be between %d and %d characters.", NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    private static final String ERROR_PRODUCT_NOT_FOUND = "This products is not in the Products list.";

    private String name;
    private final List<Product> products;

    public CategoryImpl(String name) {
        setName(name);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    //@Override
    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        // to ensure that noone could be able to change/modify anything in the original list (intentionally or by mistake) once it is created,
        // we present to the person who calls it just a copy of the original list
        return new ArrayList<>(products);
    }

    //@Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        if (!products.contains(product)) {
            throw new IllegalArgumentException(ERROR_PRODUCT_NOT_FOUND);
        }
        products.remove(product);
    }

    private static void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(NAME_NULL_ERROR);
        }
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }
    //The engine calls this method to print your category! You should not rename it!
    public String print() {
        if (products.size() == 0) {
            return String.format("#Category: %s%n #No product in this category", getName());
        }
        StringBuilder output = new StringBuilder();
        output.append(String.format("#Category: %s%n", getName()));
        for (Product product: products) {
            output.append(product.print());
        }
        return output.toString();
    }


}
