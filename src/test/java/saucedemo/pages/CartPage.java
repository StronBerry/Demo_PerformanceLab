package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By pageTitle = By.xpath("//span[@data-test='title' and text()='Your Cart']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return driver.findElement(pageTitle).isDisplayed();
    }
}