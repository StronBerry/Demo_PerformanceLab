package saucedemo.tests;

import saucedemo.base.BaseTest;
import saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginBlockedUserTest extends BaseTest {

    @Test
    public void blockedUserLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.isLockedOutErrorDisplayed());
    }
}