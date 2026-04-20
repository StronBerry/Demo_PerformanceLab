package saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;

import java.util.List;

public class AddProductsToCartTest extends BaseTest {

    @Test
    public void addProductsToCartTest() {

        var goodsList = List.of(
                "Test.allTheThings() T-Shirt (Red)",
                "Sauce Labs Onesie",
                "Sauce Labs Fleece Jacket"
        );

        loginPage.openLoginPage();
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productPage.isPageOpened());

        for (String goods : goodsList) {
            productPage.addToCart(goods);
        }

        Assert.assertEquals(productPage.getCartBadgeCount(), goodsList.size());
        Assert.assertEquals(productPage.getCartBadgeBackgroundColor(), "rgba(226, 35, 26, 1)");
    }
}