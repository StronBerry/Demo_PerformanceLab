package saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By pageTitle = By.xpath("//span[@data-test='title' and text()='Your Cart']");
    private final By productNames = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Дождаться открытия страницы корзины")
    public void waitUntilPageOpened() {
        waitUntilVisible(pageTitle);
    }

    @Step("Проверить, что открыта страница корзины")
    public boolean isPageOpened() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    @Step("Получить список товаров в корзине")
    public List<String> getProductsNames() {
        List<WebElement> allProducts = driver.findElements(productNames);
        List<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }

        return names;
    }

    @Step("Получить количество товаров в корзине")
    public int getProductsCount() {
        return driver.findElements(productNames).size();
    }
}