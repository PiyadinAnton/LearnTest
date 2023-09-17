package ui.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.helpers.Locators;
import ui.helpers.ScreenshotListener;
import ui.helpers.WebDrivers;

import java.io.IOException;

public class DashboardPage extends WebDrivers {
    Locators locators= new Locators();
    public static String Dashboard = "//h6";
    public static String DashboardElement = "#app .orangehrm-dashboard-widget-header";

    public void testElementPresence(WebDriver driver) {
        driver.get(locators.URL);
        driver.findElement(By.xpath(Dashboard)).isDisplayed();
    }

    public void setBuzz(WebDriver driver) {
        WebElement buzz = driver.findElement(By.cssSelector(BuzzPage.Buzz));
        buzz.click();
    }

    @Step("Скроллить")
    public void scroll(WebDriver driver) throws IOException, InterruptedException {
        ScreenshotListener screenshotListener = new ScreenshotListener();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        screenshotListener.takeScreenshot(driver);
    }

    @Step("Отправка заголовка страницы в командную строку")
    public void pageTitle(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String pageTitle = (String) jsExecutor.executeScript("return document.title;");
        System.out.println("Заголовок страницы: " + pageTitle);
    }

}
