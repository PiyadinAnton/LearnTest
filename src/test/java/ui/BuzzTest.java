package ui;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.helpers.ScreenshotListener;
import ui.helpers.WebDrivers;
import ui.pages.BuzzPage;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

public class BuzzTest extends WebDrivers {
    @Test
    @Description("Поделиться видео")
    public void createPostTest() throws InterruptedException {
        BuzzPage buzzPage = new BuzzPage();
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        ScreenshotListener screenshotListener = new ScreenshotListener();
        loginPage.loginVoid();
        dashboardPage.setBuzz();
        buzzPage.setCssShare();
        buzzPage.setPasteVideo();
        buzzPage.setShare();
        screenshotListener.takeScreenshot();
    }
}
