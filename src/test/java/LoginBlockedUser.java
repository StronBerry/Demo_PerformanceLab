import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginBlockedUser extends BaseTest {

    @Test
    public void blockedUserLoginTest() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        By errorMessage = By.xpath(
                "//h3[@data-test='error' and text()='Epic sadface: Sorry, this user has been locked out.']"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));

        String actualText = driver.findElement(errorMessage).getText();

        Assert.assertEquals(
                actualText,
                "Epic sadface: Sorry, this user has been locked out."
        );
    }
}