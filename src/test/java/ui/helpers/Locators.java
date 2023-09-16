package ui.helpers;

import org.openqa.selenium.*;


public class Locators extends WebDrivers {
    public static String URL = "https://opensource-demo.orangehrmlive.com/";
    public static String Menu = "//div//p[@class='oxd-userdropdown-name']";
    static String LogoutButton = "//div//a[@href=\"/web/index.php/auth/logout\"]";
    public static String Pim = "ul li:nth-child(2) a";
    public static String ExpectedElement = "//*[@id=\"app\"]//*[@role=\"cell\"][3]//*";

    public void setMenuButton(WebDriver driver) {
        WebElement menu = driver.findElement(By.xpath(Locators.Menu));
        menu.click();
    }
    public void setLogoutButton(WebDriver driver) {
        WebElement logout = driver.findElement(By.xpath(LogoutButton));
        logout.click();
    }

}
