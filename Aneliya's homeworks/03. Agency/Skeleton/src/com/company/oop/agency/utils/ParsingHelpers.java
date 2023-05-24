package com.company.oop.agency.utils;

import com.company.oop.agency.exceptions.InvalidUserInputException;

public class ParsingHelpers {

    private static final String INVALID_NUMBER_FIELD_MESSAGE = "Invalid value for %s. Should be a number.";
    private static final String INVALID_BOOLEAN_FIELD_MESSAGE = "Invalid value for %s. Should be one of 'true' or 'false'.";

    public static double tryParseDouble(String valueToParse, String parameterName) {
        try {
            return Double.parseDouble(valueToParse);
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException(String.format(INVALID_NUMBER_FIELD_MESSAGE, parameterName));
        }
    }

    public static int tryParseInteger(String valueToParse, String parameterName) {
        try {
            return Integer.parseInt(valueToParse);
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException(String.format(INVALID_NUMBER_FIELD_MESSAGE, parameterName));
        }
    }

    public static boolean tryParseBoolean(String valueToParse, String parameterName) {
        if (!valueToParse.equalsIgnoreCase("true") &&
            !valueToParse.equalsIgnoreCase("false")) {
            throw new InvalidUserInputException(String.format(INVALID_BOOLEAN_FIELD_MESSAGE, parameterName));
        }

        return Boolean.parseBoolean(valueToParse);
    }

    public static <E extends Enum<E>> E tryParseEnum(String valueToParse, Class<E> type, String errorMessage) {
        try {
            return Enum.valueOf(type, valueToParse.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(errorMessage, valueToParse));
        }
    }

}
