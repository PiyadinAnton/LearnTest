package ui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TestBase extends PageObject {
    @Step("Выход из системы")
    public static void logoutVoid() {
        PageObject.setMenuButton();
        PageObject.setLogoutButton();
    }

    @Step("Создание нового сотрудника")
    public static void createMan() {
        PageObject.setPimCss();
        PageObject.setAddXpath();
        PageObject.setFindName();
    }

    @Step("Проверка созданного сотрудника")
    public static void checkCreateMan() throws InterruptedException {
        PageObject.forCheckPim();
        PageObject.forNameSearchClick();
        PageObject.forThreadSearchElement();
    }

    @Step("Вход в систему")
    public static void loginAgain() {
        WebElement loginInput = driver.findElement(By.cssSelector(PageObject.LoginInput));
        WebElement passwordInput = driver.findElement(By.cssSelector(PageObject.PasswordInput));
        WebElement loginButton = driver.findElement(By.xpath(PageObject.LoginButton));
        loginInput.click();
        loginInput.sendKeys(PageObject.Login);
        passwordInput.click();
        passwordInput.sendKeys(PageObject.Password);
        loginButton.click();
    }

    @Step("Поиск нужного элемента")
    public static void testElementPresence() {
        driver.get(PageObject.URL);
        driver.findElement(By.cssSelector(PageObject.LoginInput)).isDisplayed();

    }

    @Step("Ткнуть на Login")
    public static void forJSFindElement() {
        PageObject.driver.get(PageObject.URL);
        WebElement loginInput = driver.findElement(By.cssSelector(PageObject.LoginInput));
        WebElement passwordInput = driver.findElement(By.cssSelector(PageObject.PasswordInput));
        WebElement element = driver.findElement(By.xpath(PageObject.LoginButton));
        loginInput.click();
        loginInput.sendKeys(PageObject.Login);
        passwordInput.click();
        passwordInput.sendKeys(PageObject.Password);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    @Step("Скроллить")
    public static void scroll() throws IOException, InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        takeScreenshot(PageObject.driver);
    }

    @Step
    public static void pageTitle() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String pageTitle = (String) jsExecutor.executeScript("return document.title;");
        System.out.println("Заголовок страницы: " + pageTitle);
    }

    @Step("Ложный вход в систему")
    public static void fakeLoginAgain() {
        WebElement loginInput = driver.findElement(By.cssSelector(PageObject.LoginInput));
        WebElement passwordInput = driver.findElement(By.cssSelector(PageObject.PasswordInput));
        WebElement loginButton = driver.findElement(By.xpath(PageObject.LoginButton));
        loginInput.click();
        loginInput.sendKeys(PageObject.FakeLogin);
        passwordInput.click();
        passwordInput.sendKeys(PageObject.FakePassword);
        loginButton.click();
    }
}