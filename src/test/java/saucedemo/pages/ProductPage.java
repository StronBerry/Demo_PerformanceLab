package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private final WebDriver driver;

    private final By pageTitle = By.xpath("//span[@data-test='title' and text()='Products']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpened() {
        return driver.findElement(pageTitle).isDisplayed();
    }
}