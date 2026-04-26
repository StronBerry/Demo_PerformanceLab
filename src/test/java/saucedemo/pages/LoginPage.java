package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(User user) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(user.getLogin());

        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(user.getPassword());

        driver.findElement(loginButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return !driver.findElements(errorMessage).isEmpty()
                && driver.findElement(errorMessage).isDisplayed();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }
}