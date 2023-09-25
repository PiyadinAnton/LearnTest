package ui.helpers;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class WebDrivers {
    @BeforeMethod
    public void exampleTest() {
        Configuration.browser = "chrome";
    }

    @AfterMethod
    public void close() {
        closeWebDriver();
    }
}