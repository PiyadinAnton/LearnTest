package ui;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.helpers.Locators;
import ui.helpers.ScreenshotListener;
import ui.helpers.WebDrivers;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;
import ui.pages.PimPage;

import static ui.helpers.Locators.*;
import static ui.pages.LoginPage.*;
import static ui.pages.PimPage.*;


public class TestBase extends WebDrivers {
    @Step("Проверка Элемента")
    public void assertLoginName(WebDriver driver) {
        WebElement loginElement = driver.findElement(By.xpath(FindName));
        Assertions.assertTrue(loginElement.isDisplayed());
    }

    @Step("Проверка Элемента")
    public void assertLoginButton(WebDriver driver) {
        WebElement loginElement = driver.findElement(By.xpath(LoginButton));
        Assertions.assertTrue(loginElement.isDisplayed());
    }

    @Step("Проверка Элемента")
    public void assertInvalidCredentials(WebDriver driver){
        WebElement loginElement = driver.findElement(By.xpath(InvalidCredentials));
        Assertions.assertTrue(loginElement.isDisplayed());
    }

    @Step("Проверка Элемента")
    public void assertCheckExpectedElementVoid(WebDriver driver) {
        WebElement expectedElement = driver.findElement(By.xpath(ExpectedElement));
        expectedElement.getText();
        Assertions.assertEquals(expectedElement.getText(), ExpectedTextForAssertEquals);
    }

    @Step("Выход из системы")
    public void logoutVoid(WebDriver driver) {
        Locators locators = new Locators();
        locators.setMenuButton(driver);
        locators.setLogoutButton(driver);
    }

    @Step("Вход в систему")
    public void login(WebDriver driver) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginVoid(driver);
    }

    @Step("Создание нового сотрудника")
    public void createMan(WebDriver driver) {
        DashboardPage dashboardPage = new DashboardPage();
        PimPage pimPage = new PimPage();
        dashboardPage.setPimCss(driver);
        pimPage.setAddXpath(driver);
        pimPage.setFindName(driver);
    }

    @Step("Проверка созданного сотрудника")
    public void checkCreateMan(WebDriver driver) throws InterruptedException {
        PimPage pimPage = new PimPage();
        pimPage.forCheckPim(driver);
        pimPage.forNameSearchClick(driver);
        pimPage.forThreadSearchElement(driver);
    }

    @Step("Поиск нужного элемента")
    public void findElementTest(WebDriver driver) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.testElementPresence(driver);
    }


    @Step("Ввод некорректных данных")
    public void fakeLoginVoid(WebDriver driver){
        LoginPage loginPage = new LoginPage();
        loginPage.fakeLoginAgain(driver);
    }

    @Step("Роняем тест")
    public void desLogin(WebDriver driver) throws InterruptedException {
        ScreenshotListener screenshotListener = new ScreenshotListener();
        login(driver);
        try {
            Assertions.assertEquals(1, 2);
        } catch (AssertionError error) {
            screenshotListener.takeScreenshot(driver);
            throw error;
        } finally {
            driver.quit();
        }
    }
}
