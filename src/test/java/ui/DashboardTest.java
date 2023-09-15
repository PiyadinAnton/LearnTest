package ui;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import java.io.IOException;

import static ui.TestBase.*;
import static ui.helpers.ScreenshotListener.expectedScreenshot;
import static ui.helpers.ScreenshotListener.takeScreenshot;
import static ui.helpers.WebDriverContainer.*;
import static ui.pages.DashboardPage.*;


public class DashboardTest {

    public static void findElementTestVoid() throws InterruptedException, IOException {
        setupApplication();
        login();
        findElementTest();
        Assertions.assertTrue(driver.findElement(By.xpath(Dashboard)).isDisplayed());
        expectedScreenshot();
        closeApplication();
    }
    public static void scrollDashboardVoid() throws IOException, InterruptedException {
        scrollDashboard();
        takeScreenshot(driver);
        Assertions.assertTrue(driver.findElement(By.cssSelector(DashboardElement)).isDisplayed());
    }
    public static void outPrintAndClosedVoid() throws IOException, InterruptedException {
        pageTitle();
        Assertions.assertTrue(driver.findElement(By.xpath(Dashboard)).isDisplayed());
        closeApplication();
    }
}

