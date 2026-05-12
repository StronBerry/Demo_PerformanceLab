package saucedemo.tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import user.User;
import user.UserFactory;

@Epic("Авторизация")
@Feature("Ошибки логина")
@Owner("Malinin S.")
public class IncorrectLoginTest extends BaseTest {

    @Story("Проверка сообщений об ошибке при некорректном логине")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("LOGIN_002")
    @Issue("ISSUE_002")
    @Test(description = "Проверка warning message при различных ошибках логина", dataProvider = "loginData")
    public void incorrectLoginTest(User user, String warningMessage) {
        loginPage.open();
        loginPage.login(user);

        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), warningMessage);
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {
                        UserFactory.withLockedPermission(),
                        "Epic sadface: Sorry, this user has been locked out."
                },
                {
                        UserFactory.withIncorrectPermission(),
                        "Epic sadface: Username and password do not match any user in this service"
                },
                {
                        UserFactory.withEmptyPagePermission(),
                        "Epic sadface: Username is required"
                }
        };
    }
}