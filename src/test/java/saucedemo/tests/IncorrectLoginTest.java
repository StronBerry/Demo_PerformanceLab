package saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import user.User;
import user.UserFactory;

public class IncorrectLoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
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