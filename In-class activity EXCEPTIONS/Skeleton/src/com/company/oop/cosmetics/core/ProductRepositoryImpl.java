package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.Category;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private static final String PRODUCT_DOES_NOT_EXIST = "Product %s does not exist.";
    private static final String CATEGORY_DOES_NOT_EXIST = "Category %s does not exist.";

    private final List<Product> products;
    private final List<Category> categories;

    public ProductRepositoryImpl() {
        this.products = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    @Override
    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product findProductByName(String productName) {
        // TODO: find a product with the given product name
        for (Product product : getProducts()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        throw new InvalidUserInputException(String.format(PRODUCT_DOES_NOT_EXIST,productName));
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        for (Category category : getCategories()) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                return category;
            }
        }
        throw new InvalidUserInputException(String.format(CATEGORY_DOES_NOT_EXIST, categoryName));
    }

    @Override
    public void createCategory(String categoryName) {
        this.categories.add(new CategoryImpl(categoryName));
    }

    @Override
    public void createProduct(String name, String brand, double price, GenderType gender) {
        this.products.add(new ProductImpl(name, brand, price, gender));
    }

    @Override
    public boolean categoryExist(String categoryName) {
        boolean exists = false;

        for (Category category : getCategories()) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    @Override
    public boolean productExist(String productName) {
        boolean exists = false;
        for (Product product : getProducts()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
}
