package ui;

import io.qameta.allure.Description;

import org.testng.annotations.Test;
import ui.helpers.ScreenshotListener;
import ui.helpers.WebDrivers;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

public class DashboardTest extends WebDrivers {
    @Test
    @Description("Поиск элемента")
    public void findElementTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        loginPage.loginVoid();
        dashboardPage.testElementPresence();
        dashboardPage.assertDashboard();
    }

    @Test
    @Description("Js Скрипт")
    public void forJSFindElement() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();
        LoginPage loginPage = new LoginPage();
        TestBase testBase = new TestBase();
        testBase.getUrl();
        loginPage.insertLoginData();
        loginPage.assertLoginButton();
        loginPage.jsClickButton();
        dashboardPage.pageTitle();
        dashboardPage.assertDashboard();
        dashboardPage.scroll();
        dashboardPage.assertDashboardElement();
    }
}

