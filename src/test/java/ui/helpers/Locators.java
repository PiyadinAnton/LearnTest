package ui.helpers;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import ui.PageObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static ui.helpers.DataProviderClass.CreateFirstName;
import static ui.helpers.DataProviderClass.CreateMiddleName;

public class Locators extends WebDriverContainer {
    static String URL = "https://opensource-demo.orangehrmlive.com/";
    public static String Menu = "//div//p[@class='oxd-userdropdown-name']";
    static String LogoutButton = "//div//a[@href=\"/web/index.php/auth/logout\"]";
    public static String Pim = "ul li:nth-child(2) a";
    public static String ExpectedElement = "//*[@id=\"app\"]//*[@role=\"cell\"][3]//*";

    public static void setMenuButton() {
        WebElement menu = driver.findElement(By.xpath(Locators.Menu));
        menu.click();
    }
    public static void setLogoutButton() {
        WebElement logout = driver.findElement(By.xpath(LogoutButton));
        logout.click();
    }

}
