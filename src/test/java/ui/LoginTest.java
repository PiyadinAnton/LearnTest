package ui;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ui.helpers.ScreenshotListener;
import ui.helpers.WebDrivers;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

import java.io.IOException;

import static ui.pages.DashboardPage.Dashboard;
import static ui.pages.DashboardPage.DashboardElement;

public class LoginTest extends TestBase {
    @Test
    @Description("Логин")
    public void loginTest(){
        WebDrivers webDrivers = new WebDrivers();
        TestBase testBase = new TestBase();

        webDrivers.open();
        testBase.login(webDrivers.driver);
        testBase.assertLoginName(webDrivers.driver);
        webDrivers.close();
    }

    @Test
    @Description("Разлогин")
    public void logoutTest() {
        WebDrivers webDrivers = new WebDrivers();
        TestBase testBase = new TestBase();

        webDrivers.open();
        testBase.login(webDrivers.driver);
        testBase.logoutVoid(webDrivers.driver);
        testBase.assertLoginButton(webDrivers.driver);
        webDrivers.close();
    }

    @Test
    @Description("Негативный")
    public void fakeLoginTest() throws InterruptedException {
        ScreenshotListener screenshotListener = new ScreenshotListener();
        WebDrivers webDrivers = new WebDrivers();
        TestBase testBase = new TestBase();

        webDrivers.open();
        testBase.fakeLoginVoid(webDrivers.driver);
        testBase.assertInvalidCredentials(webDrivers.driver);
        screenshotListener.takeScreenshot(webDrivers.driver);
        webDrivers.close();

    }

    @Test
    @Description("Уронить тест для отправки скриншота")
    public void downTest() throws InterruptedException {
        WebDrivers webDrivers = new WebDrivers();
        TestBase testBase = new TestBase();
        webDrivers.open();
        testBase.desLogin(webDrivers.driver);
    }

    @Test
    @Description("JSСкрипт")
    public void forJSFindElement() throws IOException, InterruptedException {
        WebDrivers webDrivers = new WebDrivers();
        DashboardPage dashboardPage = new DashboardPage();
        LoginPage loginPage = new LoginPage();
        TestBase testBase = new TestBase();
        webDrivers.open();
        loginPage.insertLoginData(webDrivers.driver);
        testBase.assertLoginButton(webDrivers.driver);
        loginPage.jsClickButton(webDrivers.driver);
        dashboardPage.pageTitle(webDrivers.driver);
        Assertions.assertTrue(webDrivers.driver.findElement(By.xpath(Dashboard)).isDisplayed());
        dashboardPage.scroll(webDrivers.driver);
        Assertions.assertTrue(webDrivers.driver.findElement(By.cssSelector(DashboardElement)).isDisplayed());
        webDrivers.close();
    }
}