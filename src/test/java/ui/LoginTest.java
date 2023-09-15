package ui;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ui.helpers.Locators;

import java.io.IOException;

import static io.netty.handler.codec.rtsp.RtspHeaders.Values.URL;
import static ui.helpers.ScreenshotListener.takeScreenshot;
import static ui.helpers.WebDriverContainer.*;
import static ui.helpers.WebDriverContainer.driver;
import static ui.pages.LoginPage.*;

public class LoginTest extends TestBase {

    public static void loginTestVoid() throws IOException, InterruptedException {
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
        fakeLoginVoid();
        assertInvalidCredentials();
        takeScreenshot(driver);
        closeApplication();}

    public static void downTestVoid() throws IOException, InterruptedException {
        setupApplication();
        desLogin();
        takeScreenshot(driver);

    }
    public static void forJSFindElementVoid() {
        setupApplication();
        driver.get(Locators.URL);
        insertLoginData();
        jsClickButton();
        assertLoginButton();

    }
}
