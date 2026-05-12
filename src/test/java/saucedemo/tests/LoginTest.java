package saucedemo.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import user.UserFactory;

@Epic("Авторизация")
@Feature("Логин")
@Owner("Malinin S.")
public class LoginTest extends BaseTest {

    @Story("Успешный вход в систему")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("LOGIN_001")
    @Issue("ISSUE_001")
    @Test(description = "Проверка успешного логина пользователя")
    public void loginTest() {
        loginPage
                .open()
                .loginAs(UserFactory.withCorrectData())
                .shouldBeOpened();
    }
}