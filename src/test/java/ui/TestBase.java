package ui;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.joda.time.Minutes;
import ui.helpers.WebDrivers;

import static com.codeborne.selenide.Selenide.open;
import static java.util.concurrent.TimeUnit.SECONDS;

public class TestBase extends WebDrivers {
    private final String URL = "https://opensource-demo.orangehrmlive.com/";

    @Step("Открыть сайт")
    public void getUrl() {
        open(URL);
    }
}