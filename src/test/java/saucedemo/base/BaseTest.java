package saucedemo.base;

import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import saucedemo.driver.BrowserFactory;
import utils.TestListener;

@Listeners({AllureTestNg.class, TestListener.class})
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser, ITestContext context) {

        driver = BrowserFactory.createDriver(browser);
        driver.manage().window().maximize();

        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}