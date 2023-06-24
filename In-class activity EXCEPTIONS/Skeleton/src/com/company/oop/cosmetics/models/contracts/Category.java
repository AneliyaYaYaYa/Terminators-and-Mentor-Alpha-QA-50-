package com.company.oop.cosmetics.models.contracts;

public interface Category {

    String getName();

    void addProduct(Product product);

    void removeProduct(Product product);

    String print();

}
