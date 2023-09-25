package ui;

import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ui.helpers.WebDrivers;
import ui.pages.BuzzPage;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;
@Listeners({ScreenShooter.class})
public class BuzzTest extends WebDrivers {
    @Test
    @Description("Поделиться видео")
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
