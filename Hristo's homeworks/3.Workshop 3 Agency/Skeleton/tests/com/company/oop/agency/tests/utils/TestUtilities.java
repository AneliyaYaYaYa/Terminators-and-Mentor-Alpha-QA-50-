package com.company.oop.agency.tests.utils;

import java.util.Arrays;
import java.util.List;

public class TestUtilities {

    /**
     * Returns a new List with size equal to wantedSize.
     * Useful when you do not care what the contents of the List are,
     * for example when testing if a list of a command throws exception
     * when it's parameters list's size is less/more than expected.
     *
     * @param wantedSize the size of the List to be returned.
     * @return a new List with size equal to wantedSize
     */
    public static List<String> getList(int wantedSize) {
        return Arrays.asList(new String[wantedSize]);
    }
}
