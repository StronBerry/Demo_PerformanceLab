package saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import saucedemo.driver.BrowserFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        driver = BrowserFactory.createDriver(browser);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}