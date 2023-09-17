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
        BuzzPage buzzPage = new BuzzPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        ScreenshotListener screenshotListener = new ScreenshotListener();
        loginPage.loginVoid();
        dashboardPage.setBuzz();
        Thread.sleep(3000); //неявные ожидания не ждут, пришлось так
        buzzPage.setCssShare();
        Thread.sleep(3000);
        buzzPage.setPasteVideo();
        Thread.sleep(3000);
        buzzPage.setShare();
        Thread.sleep(3000);
        screenshotListener.takeScreenshot(driver);
        close();
    }
}
