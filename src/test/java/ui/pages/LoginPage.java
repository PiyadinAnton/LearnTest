package ui.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;

import static ui.helpers.ScreenshotListener.takeScreenshot;
import static ui.helpers.WebDriverContainer.*;

public class LoginPage {
    public static String Login = "Admin";
    public static String FakeLogin = "aaa";
    public static String FakePassword = "bbb";
    public static String Password = "admin123";
    public static String LoginInput = "[name='username']";
    public static String PasswordInput = "[name='password']";
    public static String LoginButton = "//div/button";
    public static String FindName = "//div//h6";
    public static String InvalidCredentials = "//div[contains(@class, 'oxd-alert-content')]";

    public static void loginVoid() {
        WebElement loginInput = driver.findElement(By.cssSelector(LoginInput));
        WebElement passwordInput = driver.findElement(By.cssSelector(PasswordInput));
        WebElement loginButton = driver.findElement(By.xpath(LoginButton));
        loginInput.click();
        loginInput.sendKeys(Login);
        passwordInput.click();
        passwordInput.sendKeys(Password);
        loginButton.click();
    }
    public static void desLogin() throws InterruptedException, IOException {

        loginVoid();
        try {
            Assertions.assertEquals(1, 2);
        } catch (AssertionError error) {
            takeScreenshot(driver);
            throw error;
        } finally {
            closeApplication();
        }
    }

}


