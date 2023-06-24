package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.exceptions.DuplicateValueException;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;

import java.util.List;

public class CreateCategoryCommand implements Command {
    private static final int EXPECTED_PARAMETERS_COUNT = 1;
    private static final String INVALID_PARAMETERS_COUNT_MESSAGE = String.format(
            "CreateCategory command expects %d parameters.",
            EXPECTED_PARAMETERS_COUNT);
    private static final String CATEGORY_CREATED = "Category with name %s was created!";
    private static final String CATEGORY_EXIST_MESSAGE = "Category %s already exist.";

    private final ProductRepository productRepository;

    public CreateCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        //TODO Validate parameters count
        if (parameters.size() < EXPECTED_PARAMETERS_COUNT) {
            throw new InvalidUserInputException(INVALID_PARAMETERS_COUNT_MESSAGE);
        }
        String categoryName = parameters.get(0);
        return createCategory(categoryName);
    }

    private String createCategory(String categoryName) {
        //TODO Ensure category name is unique
        if (productRepository.categoryExist(categoryName)) {
            throw new DuplicateValueException(String.format(CATEGORY_EXIST_MESSAGE, categoryName));
        }
            productRepository.createCategory(categoryName);
            return String.format(CATEGORY_CREATED, categoryName);
    }
}