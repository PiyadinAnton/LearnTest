package ui;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.IOException;

public class LoginAndLogout extends PageObject {

    public static void findElementTest() throws InterruptedException, IOException {
        PageObject.setupApplication();
        TestBase.testElementPresence();
        Assertions.assertTrue(driver.findElement(By.cssSelector(PageObject.LoginInput)).isDisplayed());
        PageObject.expectedScreenshot();
        PageObject.closeApplication();
    }

    public static void login() throws InterruptedException, IOException {
        PageObject.setupApplication();
        TestBase.loginAgain();
        TestBase.assertLoginName();
        PageObject.takeScreenshot(PageObject.driver);
        PageObject.closeApplication();
    }

    public static void logOut() {
        PageObject.setupApplication();
        TestBase.loginAgain();
        TestBase.logoutVoid();
        PageObject.assertLoginButton();
        PageObject.closeApplication();
    }

    public static void desLogin() throws InterruptedException, IOException {
        PageObject.setupApplication();
        TestBase.loginAgain();
        try {
            Assertions.assertEquals(1, 2);
        } catch (AssertionError error) {
            takeScreenshot(PageObject.driver);
            throw error;
        } finally {
            PageObject.closeApplication();
        }
    }

    public static void jSTest() {
        PageObject.setupApplication();
        TestBase.forJSFindElement();
        TestBase.assertLoginButton();
        TestBase.scroll();
        TestBase.assertLoginName();
        TestBase.pageTitle();
        PageObject.closeApplication();
    }

}
