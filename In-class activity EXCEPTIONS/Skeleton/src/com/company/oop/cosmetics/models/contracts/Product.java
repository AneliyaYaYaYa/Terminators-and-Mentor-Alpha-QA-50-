package com.company.oop.cosmetics.models.contracts;

import com.company.oop.cosmetics.models.GenderType;

public interface Product {

    String getName();

    String getBrand();

    double getPrice();

    GenderType getGender();

    String print();

}
