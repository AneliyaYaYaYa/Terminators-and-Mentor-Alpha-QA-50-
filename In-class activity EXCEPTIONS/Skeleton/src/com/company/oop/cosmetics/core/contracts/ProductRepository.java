package com.company.oop.cosmetics.core.contracts;

import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;

import java.util.List;

public interface ProductRepository {

    List<Category> getCategories();

    List<Product> getProducts();

    Product findProductByName(String productName);

    Category findCategoryByName(String categoryName);

    void createCategory(String categoryToAdd);

    void createProduct(String name, String brand, double price, GenderType gender);

    boolean categoryExist(String categoryName);

    boolean productExist(String productName);

}
