package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private final By pageTitle = By.xpath("//span[@data-test='title' and text()='Products']");
    private final By cartButton = By.cssSelector("[data-test='shopping-cart-link']");
    private final By backpackAddToCartButton = By.xpath(
            "//div[@data-test='inventory-item-name' and text()='Sauce Labs Backpack']" +
                    "/ancestor::div[contains(@class,'inventory_item')]//button"
    );
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public void clickCart() {
        driver.findElement(cartButton).click();
    }

    public void clickAddToCartForBackpack() {
        driver.findElement(backpackAddToCartButton).click();
    }

    public String getBackpackButtonText() {
        return driver.findElement(backpackAddToCartButton).getText();
    }

    public String getCartBadgeText() {
        return driver.findElement(cartBadge).getText();
    }

    public String getCartBadgeBackgroundColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }
}