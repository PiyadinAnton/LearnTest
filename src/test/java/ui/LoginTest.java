package ui;

import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ui.helpers.WebDrivers;
import ui.pages.LoginPage;

import static io.qameta.allure.SeverityLevel.*;

@Listeners({ScreenShooter.class})
public class LoginTest extends WebDrivers {
    @Epic("Проверка сайта ORANGEHRM")
    @Feature("Проверка функицонала страниц")
    @Test
    @Story("Проверка входа с корректными входными параметрами")
    @Description("Логин")
    @Severity(CRITICAL)
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginVoid();
        loginPage.assertLoginName();
    }
    @Epic("Проверка сайта ORANGEHRM")
    @Feature("Проверка функицонала страниц")
    @Test
    @Story("Проверка корректного разлогина(выхода с сайта)")
    @Description("Разлогин")
    @Severity(CRITICAL)
    public void logoutTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginVoid();
        loginPage.logoutVoid();
        loginPage.assertLoginButton();

    }
    @Epic("Проверка сайта ORANGEHRM")
    @Feature("Проверка функицонала страниц")
    @Test
    @Story("Проверка входа с некорректными входными параметрами")
    @Description("Негативный")
    @Severity(CRITICAL)
    public void fakeLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.fakeLoginVoid();
        loginPage.assertInvalidCredentials();
    }
    @Epic("Задание")
    @Feature("Роняем запад")
    @Test
    @Story("Просто уронил тест")
    @Description("Уронить тест")
    @Severity(TRIVIAL)
    public void downTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.desLogin();
    }
}