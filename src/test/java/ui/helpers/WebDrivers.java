package ui.helpers;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class WebDrivers {
    @BeforeMethod
    public void exampleTest() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "--start-maximized";
    }

    @AfterClass
    public void close() {
        closeWebDriver();
    }
}