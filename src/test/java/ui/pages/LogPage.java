package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static ui.helpers.WebDriverContainer.driver;
import static ui.pages.LoginPage.*;

public class LogPage {
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public void enterUsername(String username) {
      WebElement loginInput = driver.findElement(By.cssSelector(LoginInput));
      loginInput.click();
      loginInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector(PasswordInput));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath(LoginButton));
        loginButton.click();
    }
}


