package ui;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.IOException;

public class LoginAndLogout extends PageObject {

    public static void findElementTest() throws InterruptedException, IOException {
        PageObject.setupApplication();
        PageObject.testElementPresence();
        Assertions.assertTrue(driver.findElement(By.cssSelector(PageObject.LoginInput)).isDisplayed());
        PageObject.expectedScreenshot();
        PageObject.closeApplication();
    }

    public static void login() throws InterruptedException {
        PageObject.setupApplication();
        PageObject.loginAgain();
        TestBase.assertLoginName();
        PageObject.takeScreenshot();
        PageObject.closeApplication();
    }

    public static void logOut() {
        PageObject.setupApplication();
        PageObject.loginAgain();
        TestBase.logoutVoid();
        TestBase.assertLoginButton();
        PageObject.closeApplication();
    }
}
