package com.company.cosmetics.models.common;

public enum UsageType {
    EVERYDAY,
    MEDICAL;
    
    @Override
    public String toString() {
        switch (this) {
            case EVERYDAY:
                return "EveryDay";
            case MEDICAL:
                return "Medical";
            default:
                throw new IllegalArgumentException();
        }
    }
}
