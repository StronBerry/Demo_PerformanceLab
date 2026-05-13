package saucedemo.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import saucedemo.pages.BasePage;
import saucedemo.pages.CartPage;

public class NavigationPanel extends BasePage {

    private final By cartButton = By.cssSelector("[data-test='shopping-cart-link']");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");

    public NavigationPanel(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть корзину через Navigation Panel")
    public CartPage openCart() {
        click(cartButton);
        return new CartPage(driver).waitUntilPageOpened();
    }

    @Step("Получить количество товаров в бейдже корзины")
    public int getCartBadgeCount() {
        if (driver.findElements(cartBadge).isEmpty()) {
            return 0;
        }

        return Integer.parseInt(getText(cartBadge));
    }

    @Step("Получить цвет бейджа корзины")
    public String getCartBadgeBackgroundColor() {
        String color = waitUntilVisible(cartBadge).getCssValue("background-color");
        return Color.fromString(color).asHex();
    }
}