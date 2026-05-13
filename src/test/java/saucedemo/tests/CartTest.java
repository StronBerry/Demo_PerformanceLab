package saucedemo.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.pages.LoginPage;
import user.UserFactory;

import java.util.List;

@Epic("Корзина")
@Feature("Проверка корзины")
@Owner("Malinin S.")
public class CartTest extends BaseTest {

    private final List<String> goodsList = List.of(
            "Test.allTheThings() T-Shirt (Red)",
            "Sauce Labs Onesie",
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Backpack"
    );

    @Story("Проверка товаров в корзине")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("CART_002")
    @Issue("ISSUE_004")
    @Test(description = "Проверка отображения товаров в корзине после добавления")
    public void checkGoodsInCart() {
        new LoginPage(driver)
                .open()
                .loginAs(UserFactory.withCorrectData())
                .addToCart(goodsList)
                .shouldCartBadgeCountBe(goodsList.size())
                .openCart()
                .shouldBeOpened()
                .shouldProductsCountBe(goodsList.size())
                .shouldContainProducts(goodsList);
    }
}