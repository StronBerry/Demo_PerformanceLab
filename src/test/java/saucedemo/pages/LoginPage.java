package saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import user.User;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу логина")
    public LoginPage open() {
        openBaseUrl();
        return this;
    }

    @Step("Выполнить успешный логин пользователем: {user.login}")
    public ProductPage loginAs(User user) {
        fillLoginForm(user);
        click(loginButton);
        return new ProductPage(driver).waitUntilPageOpened();
    }

    @Step("Выполнить неуспешный логин пользователем: {user.login}")
    public LoginPage loginExpectingError(User user) {
        fillLoginForm(user);
        click(loginButton);
        waitUntilVisible(errorMessage);
        return this;
    }

    @Step("Заполнить форму логина")
    private LoginPage fillLoginForm(User user) {
        type(usernameInput, user.getLogin());
        type(passwordInput, user.getPassword());
        return this;
    }

    @Step("Проверить, что отображается сообщение об ошибке")
    public LoginPage shouldErrorMessageBeDisplayed() {
        Assert.assertTrue(isVisible(errorMessage), "Error message should be displayed");
        return this;
    }

    @Step("Проверить текст сообщения об ошибке: {expectedMessage}")
    public LoginPage shouldErrorMessageTextBe(String expectedMessage) {
        Assert.assertEquals(getText(errorMessage), expectedMessage);
        return this;
    }

    @Step("Проверить, что отображается сообщение об ошибке")
    public boolean isErrorMessageDisplayed() {
        return isVisible(errorMessage);
    }

    @Step("Получить текст сообщения об ошибке")
    public String getErrorMessageText() {
        return getText(errorMessage);
    }
}