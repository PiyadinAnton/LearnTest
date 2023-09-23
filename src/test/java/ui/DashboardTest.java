package ui;

import io.qameta.allure.Description;

import org.testng.annotations.Test;
import ui.helpers.ScreenshotListener;
import ui.helpers.WebDrivers;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

import java.io.IOException;

public class DashboardTest extends WebDrivers {
    @Test
    @Description("Поиск элемента")
    public void findElementTest() throws InterruptedException, IOException {
        ScreenshotListener screenshotListener = new ScreenshotListener();
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginPage.loginVoid();
        dashboardPage.testElementPresence();
        screenshotListener.expectedScreenshot(driver);
        dashboardPage.assertDashboard();
    }

    @Test
    @Description("Js Скрипт")
    public void forJSFindElement() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        TestBase testBase = new TestBase();
        testBase.getUrl(driver);
        loginPage.insertLoginData();
        loginPage.assertLoginButton();
        loginPage.jsClickButton();
        dashboardPage.pageTitle();
        dashboardPage.assertDashboard();
        dashboardPage.scroll();
        dashboardPage.assertDashboardElement();
    }
}

