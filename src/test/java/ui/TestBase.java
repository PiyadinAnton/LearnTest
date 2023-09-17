package ui;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import ui.helpers.WebDrivers;

public class TestBase extends WebDrivers {
    public String URL = "https://opensource-demo.orangehrmlive.com/";
    public String WayToScreen = "C:\\Games\\screenshot\\myscreenshot.png";
    public String Video = "https://www.youtube.com/watch?v=Llyp-bN-wBE&ab_channel=TESFAN";

    public static String CssShare = "button.oxd-glass-button:nth-child(2)";

    public void getUrl(WebDriver driver){
        driver.get(URL);}
}
