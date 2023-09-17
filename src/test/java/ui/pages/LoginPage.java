package ui.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.TestBase;
import ui.helpers.ScreenshotListener;

public class LoginPage extends TestBase {
    private final By LoginInput = By.cssSelector("[name='username']");
    private final By PasswordInput = By.cssSelector("[name='password']");
    private final By LoginButton = By.xpath("//div/button");
    static By FindName = By.xpath("//div//h6");
    static By InvalidCredentials = By.xpath("//div[contains(@class, 'oxd-alert-content')]");
    static By LogoutButton = By.xpath("//div//a[@href=\"/web/index.php/auth/logout\"]");
    static By Menu = By.xpath("//div//p[@class='oxd-userdropdown-name']");
    final String Login = "Admin";
    final String FakeLogin = "aaa";
    final String Password = "admin123";
    final String FakePassword = "bbb";
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Проверка Элемента")
    public void assertLoginName() {
        WebElement loginElement = driver.findElement(FindName);
        Assertions.assertTrue(loginElement.isDisplayed());
    }
    @Step("Вход в систему")
    public void loginVoid() {
        getUrl(driver);
        WebElement loginInput = driver.findElement(LoginInput);
        WebElement passwordInput = driver.findElement(PasswordInput);
        WebElement loginButton = driver.findElement(LoginButton);
        loginInput.click();
        loginInput.sendKeys(Login);
        passwordInput.click();
        passwordInput.sendKeys(Password);
        loginButton.click();
    }
    public void setMenuButton() {
        driver.findElement(Menu).click();
    }

    public void setLogoutButton() {
        driver.findElement(LogoutButton).click();
    }

    @Step("Выход из системы")
    public void logoutVoid() {

        setMenuButton();
        setLogoutButton();
    }

    public void insertLoginData() {
        WebElement loginInput = driver.findElement(LoginInput);
        WebElement passwordInput = driver.findElement(PasswordInput);
        loginInput.click();
        loginInput.sendKeys(Login);
        passwordInput.click();
        passwordInput.sendKeys(Password);
    }

    public void jsClickButton() {
        WebElement element = driver.findElement(LoginButton);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    @Step("Ложный вход в систему")
    public void fakeLoginAgain() {
        getUrl(driver);
        WebElement loginInput = driver.findElement(LoginInput);
        WebElement passwordInput = driver.findElement(PasswordInput);
        WebElement loginButton = driver.findElement(LoginButton);
        loginInput.click();
        loginInput.sendKeys(FakeLogin);
        passwordInput.click();
        passwordInput.sendKeys(FakePassword);
        loginButton.click();
    }

    @Step("Проверка Элемента")
    public void assertLoginButton() {
        WebElement loginElement = driver.findElement(LoginButton);
        Assertions.assertTrue(loginElement.isDisplayed());
    }
    @Step("Проверка Элемента")
    public void assertInvalidCredentials() {
        WebElement loginElement = driver.findElement(InvalidCredentials);
        Assertions.assertTrue(loginElement.isDisplayed());
    }
    @Step("Ввод некорректных данных")
    public void fakeLoginVoid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fakeLoginAgain();
    }
    @Step("Роняем тест")
    public void desLogin() throws InterruptedException {
        ScreenshotListener screenshotListener = new ScreenshotListener();
        loginVoid();
        try {
            Assertions.assertEquals(1, 2);
        } catch (AssertionError error) {
            screenshotListener.takeScreenshot(driver);
            throw error;
        }
}
}