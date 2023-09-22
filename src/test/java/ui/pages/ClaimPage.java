package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.TestBase;

public class ClaimPage extends TestBase {
    private WebDriver driver;
    public ClaimPage (WebDriver driver) {
        this.driver = driver;}

    By Select = By.xpath("//*[contains(text(), 'Select')]");

    By Claim = By.xpath("//*[@href='/web/index.php/claim/viewClaimModule']");

    By ExpectedEl = By.xpath("//*[contains(text(), 'Accommodation')]");

    By Assign = By.xpath("//*[@class=\"orangehrm-header-container\"]//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");

    public void claimAssignAndSelect(){
        WebElement claim = driver.findElement(Claim);
        claim.click();
        WebElement assign = driver.findElement(Assign);
        assign.click();
        WebElement select = driver.findElement(Select);
        select.click();
        select.click();
        select.sendKeys(Keys.ARROW_DOWN);
        select.sendKeys(Keys.ENTER);
    }
}

