package saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private static final String ADD_TO_CART_PATTERN =
            "//div[@data-test='inventory-item-name' and text()='%s']" +
                    "/ancestor::div[contains(@class,'inventory_item')]" +
                    "//button[text()='Add to cart']";

    private final By pageTitle = By.xpath("//span[@data-test='title' and text()='Products']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверить, что открыта страница товаров")
    public boolean isPageOpened() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    @Step("Добавить товар в корзину: {goodsName}")
    public void addToCart(String goodsName) {
        By addToCartButton = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        driver.findElement(addToCartButton).click();
    }
}