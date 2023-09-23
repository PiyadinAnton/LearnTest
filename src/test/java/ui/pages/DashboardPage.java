package ui.pages;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ui.TestBase;

import ui.helpers.ScreenshotListener;

public class DashboardPage extends TestBase {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By Dashboard = By.xpath("//h6");
    private final By DashboardElement = By.cssSelector("#app .orangehrm-dashboard-widget-header");
    private final By Buzz = By.cssSelector("ul li:nth-child(12) a");

    public void setBuzz() {
        WebElement buzz = driver.findElement(Buzz);
        buzz.click();
    }

    @Step("Поиск нужного элемента")
    public void testElementPresence() {
        TestBase testBase = new TestBase();
        testBase.getUrl(driver);
        driver.findElement(Dashboard).isDisplayed();
    }

    @Step
    public void assertDashboard() {
        Assertions.assertTrue(driver.findElement(Dashboard).isDisplayed());
    }

    @Step
    public void assertDashboardElement() {
        Assertions.assertTrue(driver.findElement((DashboardElement)).isDisplayed());
    }

    @Step("Скроллить")
    public void scroll() throws InterruptedException {
        ScreenshotListener screenshotListener = new ScreenshotListener();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        screenshotListener.takeScreenshot(driver);
    }

    @Step("Отправка заголовка страницы в командную строку")
    public void pageTitle() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String pageTitle = (String) jsExecutor.executeScript("return document.title;");
        System.out.println("Заголовок страницы: " + pageTitle);
    }
}

