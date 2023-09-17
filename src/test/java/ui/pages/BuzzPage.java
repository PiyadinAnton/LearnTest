package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.TestBase;



public class BuzzPage extends TestBase {
    private WebDriver driver;
    static By Share = By.xpath( "(//*[@type='submit'])[2]");
    static By PasteVideo = By.xpath("(//*[@id=\"app\"]//textarea)[3]");
    static By CssShare = By.cssSelector("button.oxd-glass-button:nth-child(2)");

    public BuzzPage (WebDriver driver) {
        this.driver = driver;
    }

    public void setShare() {
        WebElement sharePost = driver.findElement(Share);
        sharePost.click();
    }

    public void setCssShare() {
        WebElement share = driver.findElement(CssShare);
        share.click();
    }

    public void setPasteVideo() {
        WebElement paste = driver.findElement(PasteVideo);
        paste.click();
        paste.sendKeys(Video);
    }


}
