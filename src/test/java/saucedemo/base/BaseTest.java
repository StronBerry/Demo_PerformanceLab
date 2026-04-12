package saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import saucedemo.pages.CartPage;
import saucedemo.pages.LoginPage;
import saucedemo.pages.ProductPage;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public ProductPage productPage;
    public CartPage cartPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        // options.addArguments("headless");
        options.addArguments("guest");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}