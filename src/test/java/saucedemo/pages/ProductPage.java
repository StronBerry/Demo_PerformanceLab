package saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import saucedemo.components.NavigationPanel;
import saucedemo.enums.PageTitle;
import saucedemo.enums.Product;

import java.util.List;

public class ProductPage extends BasePage {

    private static final String ADD_TO_CART_PATTERN =
            "//div[@data-test='inventory-item-name' and text()='%s']" +
                    "/ancestor::div[contains(@class,'inventory_item')]" +
                    "//button[text()='Add to cart']";

    private final By pageTitle = By.xpath("//span[@data-test='title' and text()='%s']"
            .formatted(PageTitle.PRODUCTS.getTitle()));

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

        Assert.assertTrue(
                isVisible(pageTitle),
                "Product page should be opened"
        );

        return this;
    }

    @Step("Добавить товар в корзину: {product.title}")
    public ProductPage addToCart(Product product) {
        By addToCartButton = By.xpath(ADD_TO_CART_PATTERN.formatted(product.getTitle()));
        click(addToCartButton);
        return this;
    }

    @Step("Добавить список товаров в корзину")
    public ProductPage addToCart(List<Product> products) {
        for (Product product : products) {
            addToCart(product);
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