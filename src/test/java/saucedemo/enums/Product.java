package saucedemo.enums;

public enum Product {

    TEST_ALL_THE_THINGS_T_SHIRT_RED("Test.allTheThings() T-Shirt (Red)"),
    SAUCE_LABS_ONESIE("Sauce Labs Onesie"),
    SAUCE_LABS_FLEECE_JACKET("Sauce Labs Fleece Jacket"),
    SAUCE_LABS_BACKPACK("Sauce Labs Backpack");

    private final String title;

    Product(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}