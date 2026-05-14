package saucedemo.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.enums.Product;
import saucedemo.pages.LoginPage;
import user.UserFactory;

import java.util.List;

@Epic("Корзина")
@Feature("Проверка корзины")
@Owner("Malinin S.")
public class CartTest extends BaseTest {

    private final List<Product> goodsList = List.of(
            Product.TEST_ALL_THE_THINGS_T_SHIRT_RED,
            Product.SAUCE_LABS_ONESIE,
            Product.SAUCE_LABS_FLEECE_JACKET,
            Product.SAUCE_LABS_BACKPACK
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