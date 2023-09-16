package ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static ui.helpers.WebDriverContainer.driver;
import static ui.pages.LoginPage.*;

public class RandomTest {
    public static void randomLoginVoid(String username, String password) {
        WebElement loginInput = driver.findElement(By.cssSelector(LoginInput));
        WebElement passwordInput = driver.findElement(By.cssSelector(PasswordInput));
        WebElement loginButton = driver.findElement(By.xpath(LoginButton));
        loginInput.click();
        loginInput.sendKeys(username);
        passwordInput.click();
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}