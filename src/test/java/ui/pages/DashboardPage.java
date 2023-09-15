package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ui.helpers.Locators;

import java.io.IOException;
import static ui.helpers.Locators.Pim;
import static ui.helpers.WebDriverContainer.driver;

public class DashboardPage {
    public static String Dashboard = "//h6";
    public static String DashboardElement = "#app .orangehrm-dashboard-widget-header";

    public static void testElementPresence() {
        driver.get(Locators.URL);
        driver.findElement(By.xpath(Dashboard)).isDisplayed();

    }

    public static void setPimCss() {
        WebElement pim = driver.findElement(By.cssSelector(Pim));
        pim.click();
    }
    public static void setBuzz() {
        WebElement buzz = driver.findElement(By.cssSelector(BuzzPage.Buzz));
        buzz.click();}
    @Step("Скроллить")
    public static void scroll() throws IOException, InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }


}
