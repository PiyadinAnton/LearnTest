package ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;
import ui.pages.LoginPage;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.SeverityLevel.NORMAL;

public class RandomTest extends WebDrivers {
    private final SelenideElement LoginInput = $("[name='username']");
    private final SelenideElement PasswordInput = $("[name='password']");
    private final SelenideElement LoginButton = $x("//div/button");
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        Object[][] data = new Object[1][2];
        String username = generateRandomString();
        String password = generateRandomString();
        data[0][0] = username;
        data[0][1] = password;
        return data;123
    }

    private String generateRandomString() {
        int length = 6;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
    @Epic("Задание")
    @Feature("Роняем запад")
    @Test(dataProvider = "loginData")
    @Story("Вводим рандомные данные, вдруг вход осуществится, а это баг")
    @Description("Рандомный логин")
    @Severity(NORMAL)
    public void randomLoginVoid(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        TestBase testBase = new TestBase();
        testBase.getUrl();
        LoginInput.click();
        LoginInput.sendKeys(username);
        PasswordInput.click();
        PasswordInput.sendKeys(password);
        LoginButton.click();
        loginPage.assertInvalidCredentials();
    }
}