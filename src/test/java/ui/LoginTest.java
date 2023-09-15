package ui;

import java.io.IOException;

import static ui.helpers.ScreenshotListener.takeScreenshot;
import static ui.helpers.WebDriverContainer.*;
import static ui.helpers.WebDriverContainer.driver;

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
    public static void downTestVoid(){

    }
}
