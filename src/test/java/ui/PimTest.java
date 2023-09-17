package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;

import static ui.pages.PimPage.ExpectedTextForAssertEquals;

public class PimTest extends TestBase {
    @Test
    @Description("Создать")
    public void createTest() throws InterruptedException {
        WebDrivers webDrivers = new WebDrivers();
        TestBase testBase = new TestBase();
        webDrivers.open();
        testBase.login(webDrivers.driver);
        testBase.createMan(webDrivers.driver);
        testBase.checkCreateMan(webDrivers.driver);
        assertExpectedElement(webDrivers.driver);
        webDrivers.close();
    }
}

