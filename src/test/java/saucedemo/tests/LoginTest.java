package saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import user.UserFactory;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        loginPage.open();
        loginPage.login(UserFactory.withCorrectData());

        Assert.assertTrue(productPage.isPageOpened());
    }
}