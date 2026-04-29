package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class NavigationPanel extends BasePage {

    private final By cartButton = By.cssSelector("[data-test='shopping-cart-link']");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");

    public NavigationPanel(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        driver.findElement(cartButton).click();
    }

    public int getCartBadgeCount() {
        if (driver.findElements(cartBadge).isEmpty()) {
            return 0;
        }
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }

    public String getCartBadgeBackgroundColor() {
        String color = driver.findElement(cartBadge).getCssValue("background-color");
        return Color.fromString(color).asHex();
    }
}