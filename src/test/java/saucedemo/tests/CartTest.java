package saucedemo.tests;

import org.testng.annotations.Test;
import saucedemo.base.BaseTest;

import java.util.List;

import static org.testng.Assert.*;

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
        loginPage.login("standard_user", "secret_sauce");

        for (String goods : goodsList) {
            productPage.addToCart(goods);
        }
        assertEquals(productPage.getCartBadgeText(), String.valueOf(goodsList.size()));
        productPage.switchToCart();

        assertTrue(cartPage.isPageOpened());
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), goodsList.size());

        for (String goods : goodsList) {
            assertTrue(cartPage.getProductsNames().contains(goods));
        }
    }
}