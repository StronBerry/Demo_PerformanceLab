package saucedemo.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    protected static final String BASE_URL = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(BASE_URL);
    }
}