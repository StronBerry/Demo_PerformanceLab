package saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import saucedemo.pages.CartPage;
import saucedemo.pages.LoginPage;
import saucedemo.pages.NavigationPanel;
import saucedemo.pages.ProductPage;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected NavigationPanel navigationPanel;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("headless");
        options.addArguments("guest");

        driver = new ChromeDriver(options);

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        navigationPanel = new NavigationPanel(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}