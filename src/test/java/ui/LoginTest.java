package ui;

import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ui.helpers.WebDrivers;
import ui.pages.LoginPage;

@Listeners({ScreenShooter.class})
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
        LoginPage loginPage = new LoginPage();
        loginPage.fakeLoginVoid();
        loginPage.assertInvalidCredentials();
    }

    @Test
    @Description("Уронить тест")
    public void downTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.desLogin();
    }
}