package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static ui.helpers.DataClass.Video;
import static ui.helpers.WebDriverContainer.driver;
public class BuzzPage {
    public static String CssShare = "button.oxd-glass-button:nth-child(2)";
    public static String PasteVideo = "(//*[@id=\"app\"]//textarea)[3]";
    public static String Share = "(//*[@type='submit'])[2]";
    public static String Buzz = "ul li:nth-child(12) a";


    public static void setShare() {
        WebElement sharePost = driver.findElement(By.xpath(Share));
        sharePost.click();
    }

    public static void setCssShare() {
        WebElement share = driver.findElement(By.cssSelector(CssShare));
        share.click();
    }

    public static void setPasteVideo() {
        WebElement paste = driver.findElement(By.xpath(PasteVideo));
        paste.click();
        paste.sendKeys(Video);
    }


}
