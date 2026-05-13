package saucedemo.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import user.UserFactory;

import java.util.List;

@Epic("Корзина")
@Feature("Добавление товаров")
@Owner("Malinin S.")
public class AddProductsToCartTest extends BaseTest {

    private final List<String> goodsList = List.of(
            "Test.allTheThings() T-Shirt (Red)",
            "Sauce Labs Onesie",
            "Sauce Labs Fleece Jacket"
    );

    @Story("Добавление нескольких товаров в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("CART_001")
    @Issue("ISSUE_003")
    @Test(description = "Проверка добавления товаров в корзину и отображения счетчика")
    public void addProductsToCartTest() {
        loginPage
                .open()
                .loginAs(UserFactory.withCorrectData())
                .shouldBeOpened()
                .addToCart(goodsList)
                .shouldCartBadgeCountBe(goodsList.size())
                .shouldCartBadgeColorBe("#e2231a");
    }
}