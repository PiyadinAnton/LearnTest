package ui.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import ui.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage extends TestBase {

    private final SelenideElement dashboard = $x("//h6");
    private final SelenideElement dashboardElement = $("#app .orangehrm-dashboard-widget-header");
    private final SelenideElement buzz = $("ul li:nth-child(12) a");

    @Step("Клик на Buzz")
    public void setBuzz() {
        buzz.click();
    }

    @Step("Поиск нужного элемента")
    public void testElementPresence() {
        getUrl();
    }

    @Step("Проверка наличия элемента")
    public void assertDashboard() throws InterruptedException {
        synchronized (dashboard) {
            dashboard.shouldBe(Condition.visible, Duration.ofSeconds(5));
        }
        Assert.assertTrue(dashboard.isDisplayed());
    }

    @Step("Проверка наличия элемента")
    public void assertDashboardElement() {
        Assert.assertTrue(dashboardElement.isDisplayed());
    }

    @Step("Скроллить")
    public void scroll() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        screenshot("scroll");
    }

    @Step("Отправка заголовка страницы в командную строку")
    public void pageTitle() {
        String pageTitle = executeJavaScript("return document.title;");
        System.out.println("Заголовок страницы: " + pageTitle);
    }
}
