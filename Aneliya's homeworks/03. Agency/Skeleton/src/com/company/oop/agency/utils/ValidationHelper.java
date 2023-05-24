package com.company.oop.agency.utils;

import java.util.List;

public class ValidationHelper {

    public static final String INVALID_NUMBER_OF_ARGUMENTS = "Invalid number of arguments. Expected: %d, Received: %d";

    public static void validateValueInRange(double value, double min, double max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateStringLength(String stringToValidate, int minLength, int maxLength, String errorMessage) {
        validateValueInRange(stringToValidate.length(), minLength, maxLength, errorMessage);
    }

    public static void validateArgumentsCount(List<String> list, int expectedArgumentsCount) {
        if (list.size() < expectedArgumentsCount || list.size() > expectedArgumentsCount) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, expectedArgumentsCount, list.size()));
        }
    }

}