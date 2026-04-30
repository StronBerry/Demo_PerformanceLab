package saucedemo.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    private BrowserFactory() {
    }

    public static WebDriver createDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless=new");
            options.addArguments("guest");

            return new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("safari")) {
            return new SafariDriver();
        } else {
            throw new RuntimeException("Unknown browser: " + browser);
        }
    }
}