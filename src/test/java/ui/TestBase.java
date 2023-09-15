package ui;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ui.helpers.Locators;

import java.io.IOException;

import static io.netty.handler.codec.rtsp.RtspHeaders.Values.URL;
import static ui.helpers.Locators.ExpectedElement;
import static ui.helpers.Locators.setLogoutButton;
import static ui.helpers.ScreenshotListener.takeScreenshot;
import static ui.helpers.WebDriverContainer.*;
import static ui.pages.BuzzPage.*;
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
        takeScreenshot(driver);
    }

    @Step("Выход из системы")
    public static void logoutVoid() {
        Locators.setMenuButton();
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

    public static void findElementTestVoid() throws InterruptedException, IOException {
        testElementPresence();
    }

    @Step("Поиск нужного элемента")
    public static void testElementPresence() {
        driver.get(URL);
        driver.findElement(By.cssSelector(LoginInput)).isDisplayed();

    }

    @Step("Ткнуть на Login")
    public static void forJSFindElement() {
        driver.get(URL);
        WebElement loginInput = driver.findElement(By.cssSelector(LoginInput));
        WebElement passwordInput = driver.findElement(By.cssSelector(PasswordInput));
        WebElement element = driver.findElement(By.xpath(LoginButton));
        loginInput.click();
        loginInput.sendKeys(Login);
        passwordInput.click();
        passwordInput.sendKeys(Password);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    @Step("Скроллить")
    public static void scroll() throws IOException, InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        takeScreenshot(driver);
    }

    @Step("Отправка заголовка страницы в командную строку")
    public static void pageTitle() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String pageTitle = (String) jsExecutor.executeScript("return document.title;");
        System.out.println("Заголовок страницы: " + pageTitle);
    }

    @Step("Ложный вход в систему")
    public static void fakeLoginAgain() {
        WebElement loginInput = driver.findElement(By.cssSelector(LoginInput));
        WebElement passwordInput = driver.findElement(By.cssSelector(PasswordInput));
        WebElement loginButton = driver.findElement(By.xpath(LoginButton));
        loginInput.click();
        loginInput.sendKeys(FakeLogin);
        passwordInput.click();
        passwordInput.sendKeys(FakePassword);
        loginButton.click();
    }

    public static void jSTest() throws IOException, InterruptedException {
        setupApplication();
        forJSFindElement();
        assertLoginButton();
        scroll();
        assertLoginName();
        pageTitle();
        closeApplication();
    }

    public static void create() throws InterruptedException {
        setupApplication();
        loginVoid();
        createMan();
        checkCreateMan();
        WebElement expectedElement = driver.findElement(By.xpath(ExpectedElement));
        expectedElement.getText();
        Assertions.assertEquals(expectedElement.getText(), ExpectedTextForAssertEquals);
        closeApplication();
    }

    public static void createPost() throws IOException, InterruptedException {
        setupApplication();
        loginVoid();
        setBuzz();
        Thread.sleep(3000); //явные ожидания не ждут, пришлось так
        setCssShare();
        Thread.sleep(3000);
        setPasteVideo();
        Thread.sleep(3000);
        setShare();
        Thread.sleep(3000);
        takeScreenshot(driver);
        closeApplication();
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
