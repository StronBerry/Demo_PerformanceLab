package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private static final String ADD_TO_CART_PATTERN =
            "//div[@data-test='inventory-item-name' and text()='%s']" +
                    "/ancestor::div[contains(@class,'inventory_item')]" +
                    "//button[text()='Add to cart']";

    private final By pageTitle = By.xpath("//span[@data-test='title' and text()='Products']");
    private final By cartButton = By.cssSelector("[data-test='shopping-cart-link']");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public void switchToCart() {
        driver.findElement(cartButton).click();
    }

    public void addToCart(String goodsName) {
        By addToCartButton = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        driver.findElement(addToCartButton).click();
    }

    public int getCartBadgeCount() {
        if (driver.findElements(cartBadge).isEmpty()) {
            return 0;
        }
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }

    public String getCartBadgeBackgroundColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }
}