package ui;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;

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
        testBase.assertCheckExpectedElementVoid(webDrivers.driver);
        webDrivers.close();
    }
}

