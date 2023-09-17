package ui.helpers;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

public class Locators extends WebDrivers {
    public String URL = "https://opensource-demo.orangehrmlive.com/";
    static By Menu = By.xpath("//div//p[@class='oxd-userdropdown-name']");
    static By LogoutButton = By.xpath("//div//a[@href=\"/web/index.php/auth/logout\"]");
    static By Pim = By.cssSelector("ul li:nth-child(2) a");


    public void setMenuButton(WebDriver driver) {
        driver.findElement(Menu).click();
    }
    public void setLogoutButton(WebDriver driver) {
        driver.findElement(LogoutButton).click();
    }
    public void setPimCss(WebDriver driver) {
        driver.findElement((Pim)).click();
    }
}
