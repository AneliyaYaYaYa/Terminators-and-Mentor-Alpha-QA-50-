package com.company.cosmetics.models.common;

public enum ScentType {
    LAVENDER,
    VANILLA,
    ROSE;
    
    @Override
    public String toString() {
        switch (this) {
            case ROSE:
                return "Rose";
            case VANILLA:
                return "Vanilla";
            case LAVENDER:
                return "Lavender";
            default:
                throw new IllegalArgumentException();
        }
    }
}
