package ui;

import org.openqa.selenium.WebDriver;
import ui.helpers.WebDrivers;

public class TestBase extends WebDrivers {
    private final String URL = "https://opensource-demo.orangehrmlive.com/";

    public void getUrl(WebDriver driver) {
        driver.get(URL);
    }
}