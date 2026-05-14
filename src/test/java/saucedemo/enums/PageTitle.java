package saucedemo.enums;

public enum PageTitle {

    PRODUCTS("Products"),
    YOUR_CART("Your Cart");

    private final String title;

    PageTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}