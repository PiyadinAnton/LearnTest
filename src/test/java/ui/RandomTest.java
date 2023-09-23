package ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;
import ui.pages.LoginPage;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RandomTest extends WebDrivers {
    private final SelenideElement LoginInput = $("[name='username']");
    private final SelenideElement PasswordInput = $("[name='password']");
    private final SelenideElement LoginButton = $x("//div/button");
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