package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import ui.TestBase;
import ui.helpers.ScreenshotListener;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends TestBase {
    private final SelenideElement loginInput = $("[name='username']");
    private final SelenideElement passwordInput = $("[name='password']");
    private final SelenideElement loginButton = $x("//*/button");
    private final SelenideElement findName = $x("//h6");
    private final SelenideElement invalidCredentials = $x("//*[contains(@class, 'oxd-alert-content')]");
    private final SelenideElement logoutButton = $x("//*[@href=\"/web/index.php/auth/logout\"]");
    private final SelenideElement menu = $x("//*[@class='oxd-userdropdown-name']");
    private final String login = "Admin";
    private final String  fakeLogin = "aaa";
    private final String  password = "admin123";
    private final String  fakePassword = "bbb";

    @Step("Проверка Элемента")
    public void assertLoginName() {
        findName.click();
        Assert.assertTrue(findName.isDisplayed());

    }

    @Step("Вход в систему")
    public void loginVoid() {
        getUrl();
        loginInput.click();
        loginInput.sendKeys(login);
        passwordInput.click();
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void setMenuButton() {
        menu.click();
    }

    public void setLogoutButton() {
        logoutButton.click();
    }

    @Step("Выход из системы")
    public void logoutVoid() {
        setMenuButton();
        setLogoutButton();
    }

    public void insertLoginData() {
        loginInput.click();
        loginInput.sendKeys(login);
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void jsClickButton() {
        SelenideElement element = $(loginButton);
        executeJavaScript("arguments[0].click();", element);
    }

    @Step("Ложный вход в систему")
    public void fakeLoginAgain() {
        getUrl();
        loginInput.click();
        loginInput.sendKeys(fakeLogin);
        passwordInput.click();
        passwordInput.sendKeys(fakePassword);
        loginButton.click();
    }

    @Step("Проверка Элемента")
    public void assertLoginButton() {
       loginButton.shouldBe(Condition.visible);
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @Step("Проверка Элемента")
    public void assertInvalidCredentials() throws InterruptedException {
        synchronized (invalidCredentials){
        invalidCredentials.wait(1000);}
        Assert.assertTrue(invalidCredentials.isDisplayed());
    }

    @Step("Ввод некорректных данных")
    public void fakeLoginVoid() {
        LoginPage loginPage = new LoginPage();
        loginPage.fakeLoginAgain();
    }

    @Step("Роняем тест")
    public void desLogin() {
        ScreenshotListener screenshotListener = new ScreenshotListener();
        loginVoid();
        try {
            Assert.assertEquals(1, 2);
        } catch (AssertionError error) {
            screenshotListener.takeScreenshot();
            throw error;
        }
    }
}