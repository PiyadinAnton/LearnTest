package ui;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TestBase extends PageObject {

    public static void logoutVoid() {
        PageObject.setMenuButton();
        PageObject.setLogoutButton();
    }

    public static void createMan() {
        PageObject.setPimCss();
        PageObject.setAddXpath();
        PageObject.setFindName();
    }

    public static void checkCreateMan() throws InterruptedException {
        PageObject.forCheckPim();
        PageObject.forNameSearchClick();
        PageObject.forThreadSearchElement();
    }
    public static void assertLoginName(){
        WebElement loginElement = driver.findElement(By.xpath(PageObject.FindName));
        Assertions.assertTrue(loginElement.isDisplayed());
    }
    public static void assertLoginButton(){
        WebElement loginElement = driver.findElement(By.xpath(PageObject.LoginButton));
        Assertions.assertTrue(loginElement.isDisplayed());
    }
}