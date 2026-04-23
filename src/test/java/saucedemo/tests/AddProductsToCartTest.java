package saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import user.UserFactory;

import java.util.List;

public class AddProductsToCartTest extends BaseTest {

    private final List<String> goodsList = List.of(
            "Test.allTheThings() T-Shirt (Red)",
            "Sauce Labs Onesie",
            "Sauce Labs Fleece Jacket"
    );

    @Test
    public void addProductsToCartTest() {
        loginPage.open();
        loginPage.login(UserFactory.withCorrectData());

        Assert.assertTrue(productPage.isPageOpened());

        for (String goods : goodsList) {
            productPage.addToCart(goods);
        }

        Assert.assertEquals(navigationPanel.getCartBadgeCount(), goodsList.size());
        Assert.assertEquals(navigationPanel.getCartBadgeBackgroundColor(), "rgba(226, 35, 26, 1)");
    }
}