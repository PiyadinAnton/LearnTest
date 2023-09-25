package ui;

import io.qameta.allure.Step;
import ui.helpers.WebDrivers;

import static com.codeborne.selenide.Selenide.open;

public class TestBase extends WebDrivers {
    private final String URL = "https://opensource-demo.orangehrmlive.com/";

    @Step("Открыть сайт")
    public void getUrl() {
        open(URL);
    }
}