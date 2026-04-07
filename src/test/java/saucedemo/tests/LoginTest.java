package saucedemo.tests;

import saucedemo.base.BaseTest;
import saucedemo.pages.LoginPage;
import saucedemo.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productPage.isPageOpened());
    }
}