package ui;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginAndLogout extends PageObject {

    public static void findElementTest() {
        PageObject.setupApplication();
        PageObject.testElementPresence();
        Assertions.assertTrue(driver.findElement(By.cssSelector(PageObject.LoginInput)).isDisplayed());
        PageObject.closeApplication();
    }

    public static void login() {
        PageObject.setupApplication();
        PageObject.loginAgain();
        TestBase.assertLoginName();
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
