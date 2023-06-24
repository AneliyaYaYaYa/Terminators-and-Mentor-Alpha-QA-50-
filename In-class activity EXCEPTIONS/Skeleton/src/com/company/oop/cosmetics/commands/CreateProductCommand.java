package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.DuplicateValueException;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;

import java.util.List;

public class CreateProductCommand implements Command {
    public static final int EXPECTED_PARAMETERS_COUNT = 4;
    private static final String INVALID_PARAMETERS_COUNT_MESSAGE = String.format(
            "CreateProduct command expects %d parameters.",
            EXPECTED_PARAMETERS_COUNT);

    private static final String PRODUCT_EXIST_MESSAGE = "Product %s already exist.";
    private static final String INVALID_PRICE_ERROR_MESSAGE = "Third parameter should be price (real number).";
    private static final String INVALID_GENDER_MESSAGE = "Forth parameter should be one of Men, Women or Unisex.";
    private static final String PRODUCT_CREATED = "Product with name %s was created!";
    private static final int MIN_BRAND_LENGTH = 2;
    private static final int MAX_BRAND_LENGTH = 10;
    private static final String BRAND_LENGTH_ERROR = String.format(
            "Product brand should be between %d and %d symbols.", MIN_BRAND_LENGTH, MAX_BRAND_LENGTH);
    private static final String PRICE_CAN_T_BE_NEGATIVE = "Price can't be negative.";
    private static final double MIN_PRICE = 0.0;
    private final ProductRepository productRepository;

    public CreateProductCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        //TODO Validate parameters count
        validateParameters(parameters);

        String name = parameters.get(0);
        String brand = parameters.get(1);

        //TODO Validate price format
        double price = tryParseDouble(parameters.get(2));

        //TODO Validate gender format
        GenderType gender = tryParseGenderType(parameters.get(3));

        return createProduct(name, brand, price, gender);
    }

    private void validateParameters(List<String> parameters) {
        if (parameters.size() < EXPECTED_PARAMETERS_COUNT) {
            throw new InvalidUserInputException(INVALID_PARAMETERS_COUNT_MESSAGE);
        }
    }


    private String createProduct(String name, String brand, double price, GenderType gender) {
        //TODO Ensure product name is unique
        validateCreateProduct(name, brand);
        productRepository.createProduct(name, brand, price, gender);

        return String.format(PRODUCT_CREATED, name);
    }

    private void validateCreateProduct(String name, String brand) {
        if (productRepository.productExist(name)) {
            throw new DuplicateValueException(String.format(PRODUCT_EXIST_MESSAGE, name));
        }
        if (brand.length() < MIN_BRAND_LENGTH || brand.length() > MAX_BRAND_LENGTH) {
            throw new InvalidUserInputException(BRAND_LENGTH_ERROR);
        }
    }

    private double tryParseDouble(String value) {
        try {
            double price = Double.parseDouble(value);
            if (price < MIN_PRICE) {
                throw new InvalidUserInputException(PRICE_CAN_T_BE_NEGATIVE);
            }
            return price;
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException(INVALID_PRICE_ERROR_MESSAGE);
        }
    }

    private GenderType tryParseGenderType(String value) {
        try {
            return GenderType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_GENDER_MESSAGE);
        }
    }
}
