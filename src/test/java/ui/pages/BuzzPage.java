package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.helpers.WebDrivers;


import static ui.helpers.DataClass.Video;

public class BuzzPage extends WebDrivers {
    public static String CssShare = "button.oxd-glass-button:nth-child(2)";
    public static String PasteVideo = "(//*[@id=\"app\"]//textarea)[3]";
    public static String Share = "(//*[@type='submit'])[2]";
    public static String Buzz = "ul li:nth-child(12) a";

    public void setShare(WebDriver driver) {
        WebElement sharePost = driver.findElement(By.xpath(Share));
        sharePost.click();
    }

    public void setCssShare(WebDriver driver) {
        WebElement share = driver.findElement(By.cssSelector(CssShare));
        share.click();
    }

    public void setPasteVideo(WebDriver driver) {
        WebElement paste = driver.findElement(By.xpath(PasteVideo));
        paste.click();
        paste.sendKeys(Video);
    }


}
