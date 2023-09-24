package ui;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.helpers.ScreenshotListener;
import ui.helpers.WebDrivers;
import ui.pages.LoginPage;

public class LoginTest extends WebDrivers {
    @Test
    @Description("Логин")
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginVoid();
        loginPage.assertLoginName();
    }

    @Test
    @Description("Разлогин")
    public void logoutTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginVoid();
        loginPage.logoutVoid();
        loginPage.assertLoginButton();

    }

    @Test
    @Description("Негативный")
    public void fakeLoginTest() throws InterruptedException {
        ScreenshotListener screenshotListener = new ScreenshotListener();
        LoginPage loginPage = new LoginPage();
        loginPage.fakeLoginVoid();
        loginPage.assertInvalidCredentials();
        screenshotListener.takeScreenshot();
    }

    @Test
    @Description("Уронить тест для отправки скриншота")
    public void downTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.desLogin();

}}