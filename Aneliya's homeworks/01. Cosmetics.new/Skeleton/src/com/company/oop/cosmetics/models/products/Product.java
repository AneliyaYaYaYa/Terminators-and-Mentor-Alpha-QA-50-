package com.company.oop.cosmetics.models.products;

import com.company.oop.cosmetics.models.common.GenderType;

public class Product {
    //static - if we want to use the field from this class in another class without an instance
    //static shte e obshto pole za vs obekti ot edin klass
    //static se izpolzva za counter-i obiknoveno
    //final ne moje da se promenya, ne moje dori sys setter
    // static variable se vikat prez imeto na klasa/Person.getId, a non-static - prez imeto na obekta/instanciya p1,getId
    private static final int MIN_LENGTH_PRODUCT_NAME = 3;
    private static final int MAX_LENGTH_PRODUCT_NAME = 10;
    private static final String PRODUCT_NAME_ERROR = String.format(
            "Product name must be between %d and %d characters.",
            MIN_LENGTH_PRODUCT_NAME, MAX_LENGTH_PRODUCT_NAME);
    private static final int MIN_LENGTH_BRAND_NAME = 2;
    private static final int MAX_LENGTH_BRAND_NAME = 10;
    private static final String BRAND_NAME_ERROR = String.format("" +
                    "Brand name must be between %d and %d characters.",
            MIN_LENGTH_BRAND_NAME, MAX_LENGTH_BRAND_NAME);
    private static final String PRODUCT_NAME_NULL_ERROR = String.format(
            "Product name cannot be null.");
    public static final String PRICE_ERROR = String.format("Price cannot be negative.");
    public static final String GENDER_ERROR = "Gender cannot be null.";
    private double price;
    private String name;
    private String brand;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }
//ako nyama Constructro ima edin po podrazbirane bez referencii
//v konstruktura vliza neshto provereno veche /provereno v setter

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException(PRICE_ERROR);
        }
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.length() < MIN_LENGTH_PRODUCT_NAME || name.length() > MAX_LENGTH_PRODUCT_NAME) {
            throw new IllegalArgumentException(PRODUCT_NAME_ERROR);
        }
        if (name == null || name == " ") {
            throw new IllegalArgumentException(PRODUCT_NAME_NULL_ERROR);
        }
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        if (brand.length() > MIN_LENGTH_BRAND_NAME && brand.length() < MAX_LENGTH_BRAND_NAME) {
            this.brand = brand;
        } else {
            throw new IllegalArgumentException(BRAND_NAME_ERROR);
        }
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        if (gender == null){
            throw new IllegalArgumentException(GENDER_ERROR);
        }
        this.gender = gender;
    }
//enums for formating is %s
    public String print() {
        String message = String.format(" #%s %s%n #Price: $%.2f%n #Gender: %s%n ===",
                name, brand, price, gender);
        return message;

        //return String.format(" #[%s] [%s]%n#Price: [$%.2f]%n#Gender: [%s]%n===%n",
        //                name, brand, price, gender);

        // Format:
        //" #[Name] [Brand]
        // #Price: [Price]
        // #Gender: [Gender]
        // ==="
    }

}
