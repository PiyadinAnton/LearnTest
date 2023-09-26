package ui;

import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

import static io.qameta.allure.SeverityLevel.NORMAL;


@Listeners({ScreenShooter.class})
public class DashboardTest extends WebDrivers {
    @Epic("Проверка сайта ORANGEHRM")
    @Feature("Проверка функицонала страниц")
    @Test
    @Description("Поиск элемента")
    @Story("Проверка что элемент появился после логина")
    @Severity(NORMAL)
    public void findElementTest() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        loginPage.loginVoid();
        dashboardPage.testElementPresence();
        dashboardPage.assertDashboard();
    }
    @Epic("По заданию")
    @Feature("Проверка JS")
    @Test
    @Story("Логин с помощью JS скрипта")
    @Description("Js Скрипт")
    @Severity(NORMAL)
    public void forJSFindElement()  {
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

