package ui;

import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;
import ui.pages.LoginPage;

import java.util.Random;


public class RandomTest extends WebDrivers {
    private final By LoginInput = By.cssSelector("[name='username']");
    private final By PasswordInput = By.cssSelector("[name='password']");
    private final By LoginButton = By.xpath("//div/button");
    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        Random random = new Random();
        int count = random.nextInt(5) + 1;
        Object[][] data = new Object[count][2];
        for (int i = 0; i < count; i++) {
            String username = generateRandomString();
            String password = generateRandomString();
            data[i][0] = username;
            data[i][1] = password;
        }
        return data;
    }

    private String generateRandomString() {
        int length = 6;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
    @Test(dataProvider = "loginData")
    @Description("Рандомный логин")
    public void randomLoginVoid(String username, String password)  {
        LoginPage loginPage = new LoginPage(driver);
        TestBase testBase = new TestBase();
        testBase.getUrl(driver);
        WebElement loginInput = driver.findElement(LoginInput);
        WebElement passwordInput = driver.findElement(PasswordInput);
        WebElement loginButton = driver.findElement(LoginButton);

        loginInput.click();
        loginInput.sendKeys(username);
        passwordInput.click();
        passwordInput.sendKeys(password);
        loginButton.click();
        loginPage.assertInvalidCredentials();
        close();
    }
}