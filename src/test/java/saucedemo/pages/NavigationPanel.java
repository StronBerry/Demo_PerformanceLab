package saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class NavigationPanel extends BasePage {

    private final By cartButton = By.cssSelector("[data-test='shopping-cart-link']");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");

    public NavigationPanel(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть корзину")
    public void openCart() {
        driver.findElement(cartButton).click();
    }

    @Step("Получить количество товаров в корзине")
    public int getCartBadgeCount() {
        if (driver.findElements(cartBadge).isEmpty()) {
            return 0;
        }
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }

    @Step("Получить цвет бейджа корзины")
    public String getCartBadgeBackgroundColor() {
        String color = driver.findElement(cartBadge).getCssValue("background-color");
        return Color.fromString(color).asHex();
    }
}