package saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;

public class AddBackpackToCartTest extends BaseTest {

    @Test
    public void addBackpackToCartTest() {
        loginPage.openLoginPage();
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productPage.isPageOpened());

        productPage.clickAddToCartForBackpack();

        Assert.assertEquals(productPage.getBackpackButtonText(), "Remove");
        Assert.assertEquals(productPage.getCartBadgeText(), "1");
        Assert.assertEquals(productPage.getCartBadgeBackgroundColor(), "rgba(226, 35, 26, 1)");
    }
}