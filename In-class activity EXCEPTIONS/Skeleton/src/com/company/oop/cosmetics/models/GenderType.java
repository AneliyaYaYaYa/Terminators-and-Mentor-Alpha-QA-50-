package com.company.oop.cosmetics.models;

public enum GenderType {
    MEN,
    WOMEN,
    UNISEX;

    @Override
    public String toString() {
        switch (this) {
            case WOMEN:
                return "Women";
            case UNISEX:
                return "Unisex";
            case MEN:
                return "Men";
            default:
                return "Unknown";
        }
    }
}
