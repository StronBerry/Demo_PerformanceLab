package saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;

public class CartTest extends BaseTest {

    @Test
    public void openCartTest() {
        loginPage.openLoginPage();
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productPage.isPageOpened());

        productPage.clickCart();

        Assert.assertTrue(cartPage.isPageOpened());
    }
}