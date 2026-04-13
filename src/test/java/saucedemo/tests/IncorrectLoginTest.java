package saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;

public class IncorrectLoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void checkIncorrectLogin(String user, String password, String errorMessage) {

        loginPage.openLoginPage();
        loginPage.login(user, password);

        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), errorMessage);
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }
}