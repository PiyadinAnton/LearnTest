package ui;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.helpers.ScreenshotListener;
import ui.helpers.WebDrivers;
import ui.pages.BuzzPage;
import ui.pages.DashboardPage;

public class BuzzTest extends TestBase {
    @Test
    @Description("Поделиться видео")
    public static void createPostTest() throws InterruptedException {
        WebDrivers webDrivers = new WebDrivers();
        BuzzPage buzzPage = new BuzzPage();
        DashboardPage dashboardPage = new DashboardPage();
        TestBase testBase = new TestBase();
        ScreenshotListener screenshotListener = new ScreenshotListener();
        webDrivers.open();
        testBase.login(webDrivers.driver);
        dashboardPage.setBuzz(webDrivers.driver);
        Thread.sleep(3000); //неявные ожидания не ждут, пришлось так
        buzzPage.setCssShare(webDrivers.driver);
        Thread.sleep(3000);
        buzzPage.setPasteVideo(webDrivers.driver);
        Thread.sleep(3000);
        buzzPage.setShare(webDrivers.driver);
        Thread.sleep(3000);
        screenshotListener.takeScreenshot(webDrivers.driver);
        webDrivers.close();
    }
}
