package saucedemo.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.enums.Product;
import saucedemo.pages.LoginPage;
import user.UserFactory;

import java.util.List;

@Epic("Корзина")
@Feature("Добавление товаров")
@Owner("Malinin S.")
public class AddProductsToCartTest extends BaseTest {

    private final List<Product> goodsList = List.of(
            Product.TEST_ALL_THE_THINGS_T_SHIRT_RED,
            Product.SAUCE_LABS_ONESIE,
            Product.SAUCE_LABS_FLEECE_JACKET
    );

    @Story("Добавление нескольких товаров в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("CART_001")
    @Issue("ISSUE_003")
    @Test(description = "Проверка добавления товаров в корзину и отображения счетчика")
    public void addProductsToCartTest() {
        new LoginPage(driver)
                .open()
                .loginAs(UserFactory.withCorrectData())
                .shouldBeOpened()
                .addToCart(goodsList)
                .shouldCartBadgeCountBe(goodsList.size())
                .shouldCartBadgeColorBe("#e2231a");
    }
}