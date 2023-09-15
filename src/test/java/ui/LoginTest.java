package ui;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.IOException;

import static ui.helpers.ScreenshotListener.expectedScreenshot;
import static ui.helpers.ScreenshotListener.takeScreenshot;
import static ui.helpers.WebDriverContainer.*;
import static ui.helpers.WebDriverContainer.driver;
import static ui.pages.LoginPage.LoginInput;

public class LoginTest extends TestBase{

    public static void loginTestVoid () throws IOException, InterruptedException {
        setupApplication();
        login();
        assertLoginName();
        closeApplication();
    }
    public static void logoutTestVoid() throws IOException, InterruptedException {
        setupApplication();
        login();
        logoutVoid();
        assertLoginButton();
        closeApplication();
    }
    public static void fakeLoginTestVoid() throws IOException, InterruptedException {
        setupApplication();
        fakeLoginAgain();
        assertInvalidCredentials();
        takeScreenshot(driver);
        closeApplication();

        }
    public static void downTestVoid() throws IOException, InterruptedException {
        setupApplication();
        desLogin();
        takeScreenshot(driver);

    }
    public static void findElementTest() throws InterruptedException, IOException {
        setupApplication();
        findElementTestVoid();
        Assertions.assertTrue(driver.findElement(By.cssSelector(LoginInput)).isDisplayed());
        expectedScreenshot();
        closeApplication();
    }
}
