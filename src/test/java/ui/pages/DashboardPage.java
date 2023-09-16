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

import static ui.helpers.Locators.Pim;

public class DashboardPage extends WebDrivers {
    public static String Dashboard = "//h6";
    public static String DashboardElement = "#app .orangehrm-dashboard-widget-header";

    public void testElementPresence(WebDriver driver) {
        driver.get(Locators.URL);
        driver.findElement(By.xpath(Dashboard)).isDisplayed();
    }

    public void setPimCss(WebDriver driver) {
        WebElement pim = driver.findElement(By.cssSelector(Pim));
        pim.click();
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
