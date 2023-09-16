package ui;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ui.helpers.ScreenshotListener;
import ui.helpers.WebDrivers;

import java.io.IOException;

import static ui.pages.DashboardPage.*;

public class DashboardTest extends TestBase {
    @Test
    @Description("Поиск элемента")
    public  void findElementTest() throws InterruptedException, IOException {
        ScreenshotListener screenshotListener = new ScreenshotListener();
        WebDrivers webDrivers = new WebDrivers();
        TestBase testBase = new TestBase();

        webDrivers.open();
        testBase.login(webDrivers.driver);
        testBase.findElementTest(webDrivers.driver);
        screenshotListener.expectedScreenshot(webDrivers.driver);
        Assertions.assertTrue(webDrivers.driver.findElement(By.xpath(Dashboard)).isDisplayed());
        webDrivers.close();
    }
}

