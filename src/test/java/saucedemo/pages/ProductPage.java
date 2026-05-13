package saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import saucedemo.components.NavigationPanel;

import java.util.List;

public class ProductPage extends BasePage {

    private static final String ADD_TO_CART_PATTERN =
            "//div[@data-test='inventory-item-name' and text()='%s']" +
                    "/ancestor::div[contains(@class,'inventory_item')]" +
                    "//button[text()='Add to cart']";

    private final By pageTitle = By.xpath("//span[@data-test='title' and text()='Products']");

    private final NavigationPanel navigationPanel;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.navigationPanel = new NavigationPanel(driver);
    }

    @Step("Дождаться открытия страницы товаров")
    public ProductPage waitUntilPageOpened() {
        waitUntilVisible(pageTitle);
        return this;
    }

    @Step("Проверить, что открыта страница товаров")
    public ProductPage shouldBeOpened() {
        Assert.assertTrue(isPageOpened(), "Product page should be opened");
        return this;
    }

    @Step("Проверить, что открыта страница товаров")
    public boolean isPageOpened() {
        return isVisible(pageTitle);
    }

    @Step("Добавить товар в корзину: {goodsName}")
    public ProductPage addToCart(String goodsName) {
        By addToCartButton = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        click(addToCartButton);
        return this;
    }

    @Step("Добавить список товаров в корзину")
    public ProductPage addToCart(List<String> goodsNames) {
        for (String goodsName : goodsNames) {
            addToCart(goodsName);
        }

        return this;
    }

    @Step("Открыть корзину")
    public CartPage openCart() {
        return navigationPanel.openCart();
    }

    @Step("Проверить количество товаров в бейдже корзины: {expectedCount}")
    public ProductPage shouldCartBadgeCountBe(int expectedCount) {
        Assert.assertEquals(navigationPanel.getCartBadgeCount(), expectedCount);
        return this;
    }

    @Step("Проверить цвет бейджа корзины: {expectedColor}")
    public ProductPage shouldCartBadgeColorBe(String expectedColor) {
        Assert.assertEquals(navigationPanel.getCartBadgeBackgroundColor(), expectedColor);
        return this;
    }
}