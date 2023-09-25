package ui.helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import ui.TestBase;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.*;

public class ScreenshotListener extends TestBase {
    @Step("Отправка скриншота для подтверждения теста")
    public void takeScreenshot() {
        screenshot("Screenshot");
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(Selenide.screenshot("Screenshot").getBytes()));
    }
}