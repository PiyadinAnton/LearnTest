package ui;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import java.io.IOException;


import static ui.helpers.Locators.*;

import static ui.helpers.ScreenshotListener.takeScreenshot;

import static ui.pages.DashboardPage.*;
import static ui.pages.LoginPage.*;
import static ui.pages.PimPage.*;


public class TestBase {
    @Step("Проверка Элемента")
    public static void assertLoginName() {
        WebElement loginElement = driver.findElement(By.xpath(FindName));
        Assertions.assertTrue(loginElement.isDisplayed());
    }

    @Step("Проверка Элемента")
    public static void assertLoginButton() {
        WebElement loginElement = driver.findElement(By.xpath(LoginButton));
        Assertions.assertTrue(loginElement.isDisplayed());
    }

    @Step("Проверка Элемента")
    public static void assertInvalidCredentials() throws IOException, InterruptedException {
        WebElement loginElement = driver.findElement(By.xpath(InvalidCredentials));
        Assertions.assertTrue(loginElement.isDisplayed());
    }

    @Step("Проверка Элемента")
    public static void assertCheckExpectedElementVoid() {
        WebElement expectedElement = driver.findElement(By.xpath(ExpectedElement));
        expectedElement.getText();
        Assertions.assertEquals(expectedElement.getText(), ExpectedTextForAssertEquals);
    }

    @Step("Выход из системы")
    public static void logoutVoid() {
        setMenuButton();
        setLogoutButton();
    }

    @Step("Вход в систему")
    public static void login() throws InterruptedException, IOException {
        loginVoid();

    }

    @Step("Создание нового сотрудника")
    public static void createMan() {
        setPimCss();
        setAddXpath();
        setFindName();
    }

    @Step("Проверка созданного сотрудника")
    public static void checkCreateMan() throws InterruptedException {
        forCheckPim();
        forNameSearchClick();
        forThreadSearchElement();
    }

    @Step("Поиск нужного элемента")
    public static void findElementTest() throws InterruptedException, IOException {
        testElementPresence();
    }
    @Step("Cкроллить страничку")
    public static void scrollDashboard() throws IOException, InterruptedException {
        scroll();
        takeScreenshot(driver);
    }
    @Step("Отправка заголовка страницы в командную строку")
    public static void pageTitle() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String pageTitle = (String) jsExecutor.executeScript("return document.title;");
        System.out.println("Заголовок страницы: " + pageTitle);
    }

    @Step("Ввод некорректных данных")
    public static void fakeLoginVoid() throws IOException, InterruptedException {
        fakeLoginAgain();
    }
    @Step("Роняем тест")
    public static void desLogin() throws InterruptedException, IOException {
        login();
        try {
            Assertions.assertEquals(1, 2);
        } catch (AssertionError error) {
            takeScreenshot(driver);
            throw error;
        } finally {
            closeApplication();
        }
    }
}
