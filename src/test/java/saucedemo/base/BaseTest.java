package saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import saucedemo.driver.BrowserFactory;
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
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        driver = BrowserFactory.createDriver(browser);
        driver.manage().window().maximize();

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