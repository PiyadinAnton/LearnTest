package ui;

import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ui.helpers.WebDrivers;
import ui.pages.BuzzPage;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Listeners({ScreenShooter.class})
public class BuzzTest extends WebDrivers {
    @Epic("Проверка сайта ORANGEHRM")
    @Feature("Проверка функицонала страниц")
    @Test
    @Story("Проверка функционала: Share video")
    @Description("Поделиться видео")
    @Severity(CRITICAL)
    public void createPostTest() throws InterruptedException {
        BuzzPage buzzPage = new BuzzPage();
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        loginPage.loginVoid();
        dashboardPage.setBuzz();
        buzzPage.setCssShare();
        buzzPage.setPasteVideo();
        buzzPage.setShare();
    }
}
