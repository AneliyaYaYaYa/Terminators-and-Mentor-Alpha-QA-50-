package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.contracts.Category;

import java.util.List;

public class ShowCategoryCommand implements Command {

    private final ProductRepository productRepository;
    public static  int EXPECTED_PARAMETERS_COUNT = 1;
    private static final String INVALID_PARAMETERS_COUNT_MESSAGE = String.format(
            "ShowCategory command expects %d parameters.",
            EXPECTED_PARAMETERS_COUNT);

    public ShowCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        //TODO Validate parameters count
        validateParameters(parameters);
        String categoryName = parameters.get(0);
        return showCategory(categoryName);
    }
    private static void validateParameters(List<String> parameters) {
        if (parameters.size() < EXPECTED_PARAMETERS_COUNT) {
            throw new InvalidUserInputException(INVALID_PARAMETERS_COUNT_MESSAGE);
        }
    }

    private String showCategory(String categoryName) {
        Category category = productRepository.findCategoryByName(categoryName);
        return category.print();
    }
}
