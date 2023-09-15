package ui.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.io.IOException;

import static ui.helpers.ScreenshotListener.takeScreenshot;
import static ui.helpers.WebDriverContainer.*;

public class LoginPage {
    public static String Login = "Admin";
    public static String FakeLogin = "aaa";
    public static String FakePassword = "bbb";
    public static String Password = "admin123";
    public static String LoginInput = "[name='username']";
    public static String PasswordInput = "[name='password']";
    public static String LoginButton = "//div/button";
    public static String FindName = "//div//h6";
    public static String InvalidCredentials = "//div[contains(@class, 'oxd-alert-content')]";

    public static void loginVoid() {
        WebElement loginInput = driver.findElement(By.cssSelector(LoginInput));
        WebElement passwordInput = driver.findElement(By.cssSelector(PasswordInput));
        WebElement loginButton = driver.findElement(By.xpath(LoginButton));
        loginInput.click();
        loginInput.sendKeys(Login);
        passwordInput.click();
        passwordInput.sendKeys(Password);
        loginButton.click();
    }

    public static void insertLoginData() {
        WebElement loginInput = driver.findElement(By.cssSelector(LoginInput));
        WebElement passwordInput = driver.findElement(By.cssSelector(PasswordInput));
        loginInput.click();
        loginInput.sendKeys(Login);
        passwordInput.click();
        passwordInput.sendKeys(Password);
    }

    public static void jsClickButton() {
        WebElement element = driver.findElement(By.xpath(LoginButton));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
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
}

