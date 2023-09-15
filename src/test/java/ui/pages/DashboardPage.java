package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static ui.helpers.Locators.Menu;
import static ui.helpers.Locators.Pim;
import static ui.helpers.WebDriverContainer.driver;

public class DashboardPage {

    public static void setMenuButton() {
        WebElement menu = driver.findElement(By.xpath(Menu));
        menu.click();
    }
    public static void setPimCss() {
        WebElement pim = driver.findElement(By.cssSelector(Pim));
        pim.click();
    }
    public static void setBuzz() {
        WebElement buzz = driver.findElement(By.cssSelector(BuzzPage.Buzz));
        buzz.click();}

}
