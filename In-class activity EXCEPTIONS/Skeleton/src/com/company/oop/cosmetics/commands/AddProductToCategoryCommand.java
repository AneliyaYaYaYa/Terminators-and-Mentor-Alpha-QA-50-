package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;

import java.util.List;

public class AddProductToCategoryCommand implements Command {
    private static final int EXPECTED_PARAMETERS_COUNT = 2;
    private static final String INVALID_PARAMETERS_COUNT_MESSAGE = String.format(
            "AddProductToCategory command expects %d parameters.",
            EXPECTED_PARAMETERS_COUNT);
    private static final String PRODUCT_ADDED_TO_CATEGORY = "Product %s added to category %s!";
    private final ProductRepository productRepository;
    public AddProductToCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        validateParameters(parameters);

        String categoryNameToAdd = parameters.get(0);
        String productNameToAdd = parameters.get(1);

        return addProductToCategory(categoryNameToAdd, productNameToAdd);
    }
    private void validateParameters(List<String> parameters) {
        if (parameters.size() < EXPECTED_PARAMETERS_COUNT) {
            throw new InvalidUserInputException(INVALID_PARAMETERS_COUNT_MESSAGE);
        }
    }

    private String addProductToCategory(String categoryName, String productName) {
        Category category = productRepository.findCategoryByName(categoryName);
        Product product = productRepository.findProductByName(productName);

        category.addProduct(product);

        return String.format(PRODUCT_ADDED_TO_CATEGORY, productName, categoryName);
    }

}
