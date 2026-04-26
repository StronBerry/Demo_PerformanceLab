package saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import user.UserFactory;

import java.util.List;

public class CartTest extends BaseTest {

    private final List<String> goodsList = List.of(
            "Test.allTheThings() T-Shirt (Red)",
            "Sauce Labs Onesie",
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Backpack"
    );

    @Test
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(UserFactory.withCorrectData());

        for (String goods : goodsList) {
            productPage.addToCart(goods);
        }

        Assert.assertEquals(navigationPanel.getCartBadgeCount(), goodsList.size());

        navigationPanel.openCart();
        cartPage.waitUntilPageOpened();

        Assert.assertTrue(cartPage.isPageOpened());
        Assert.assertEquals(cartPage.getProductsCount(), goodsList.size());

        List<String> actualProducts = cartPage.getProductsNames();

        for (String goods : goodsList) {
            Assert.assertTrue(actualProducts.contains(goods));
        }
    }
}