package ui.helpers;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDrivers {

    @BeforeMethod
    public void setUP() {
         Configuration.browser = Browsers.CHROME;
         open();
         getWebDriver().manage().window().maximize();


    }

    @AfterMethod
    public void close() {
        closeWebDriver();
        clearBrowserCache();
    }
}