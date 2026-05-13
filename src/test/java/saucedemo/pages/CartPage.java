package saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By pageTitle = By.xpath("//span[@data-test='title' and text()='Your Cart']");
    private final By productNames = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Дождаться открытия страницы корзины")
    public CartPage waitUntilPageOpened() {
        waitUntilVisible(pageTitle);
        return this;
    }

    @Step("Проверить, что открыта страница корзины")
    public CartPage shouldBeOpened() {
        Assert.assertTrue(isPageOpened(), "Cart page should be opened");
        return this;
    }

    @Step("Проверить, что открыта страница корзины")
    public boolean isPageOpened() {
        return isVisible(pageTitle);
    }

    @Step("Проверить количество товаров в корзине: {expectedCount}")
    public CartPage shouldProductsCountBe(int expectedCount) {
        Assert.assertEquals(getProductsCount(), expectedCount);
        return this;
    }

    @Step("Проверить, что корзина содержит товары")
    public CartPage shouldContainProducts(List<String> expectedProducts) {
        List<String> actualProducts = getProductsNames();

        for (String expectedProduct : expectedProducts) {
            Assert.assertTrue(
                    actualProducts.contains(expectedProduct),
                    "Cart should contain product: " + expectedProduct
            );
        }

        return this;
    }

    @Step("Получить список товаров в корзине")
    public List<String> getProductsNames() {
        List<WebElement> allProducts = waitUntilAllVisible(productNames);
        List<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }

        return names;
    }

    @Step("Получить количество товаров в корзине")
    public int getProductsCount() {
        return findAll(productNames).size();
    }
}