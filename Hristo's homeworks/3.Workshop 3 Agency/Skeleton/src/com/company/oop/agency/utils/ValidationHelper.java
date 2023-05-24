package com.company.oop.agency.utils;

import java.util.List;

public class ValidationHelper {

    private static final String INVALID_NUMBER_OF_ARGUMENTS = "Invalid number of arguments. Expected: %d, Received: %d";


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

    public static void againstNull(Object object, String errorMessage) {
        if (object == null) {
            throw new NullPointerException(errorMessage);

        }
    }

    public static void againstNegativeValue(int value, String errorMessage) {
        if (value < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validatePricePerKilometers(double value, double minPrice, double maxPrice, String errorMessage) {
        if (value < minPrice || value > maxPrice) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validatePassengerCapacity(int value, int minPas, int maxPas, String errorMessage) {
        if (value < minPas || value > maxPas) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateCarts(int value, int min, int max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(errorMessage);
        }


    }
}