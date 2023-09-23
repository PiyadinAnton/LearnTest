package ui.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.TestBase;
public class ClaimPage extends TestBase {
    private WebDriver driver;
    public ClaimPage (WebDriver driver) {
        this.driver = driver;}

    private final By Select = By.xpath("//*[contains(text(), 'Select')][1]");
    private final By SelectVer2 = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']/div[@class='oxd-select-text-input'][1]");

    private final By Claim = By.xpath("//*[@href='/web/index.php/claim/viewClaimModule']");

    private final By ExpectedEl = By.xpath("//*[contains(text(), 'Accommodation')]");

    private final By Remark = By.xpath("//*[@class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]");

    private final By Assign = By.xpath("//*[@class=\"orangehrm-header-container\"]//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");

    private final By EmployeTypeForHints = By.xpath("//*[@placeholder=\"Type for hints...\"]");

    private final By Create = By.xpath("//*[@type=\"submit\"]");
    private final By Submit = By.xpath("//*[@type=\"button\" and @class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-sm-button\"]");
    private final By Back = By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--ghost orangehrm-sm-button\"]");

    private final By assertAlice = By.xpath("//*[contains(text(), 'Alice Duval')]");
    private final String NameEmployer = "Alice  Duval";
    private final String Text = "Random text";

    @Step("Создать Claim")
    public void claimAssignAndSelect() throws InterruptedException {
        WebElement claim = driver.findElement(Claim);
        claim.click();
        WebElement assign = driver.findElement(Assign);
        assign.click();
        WebElement select = driver.findElement(Select);
        Thread.sleep(1000);
        select.sendKeys(Keys.ARROW_DOWN);
        select.sendKeys(Keys.ENTER);
        WebElement selectForEnter = driver.findElement(SelectVer2);
        Thread.sleep(1000);
        selectForEnter.sendKeys(Keys.ARROW_DOWN);
        selectForEnter.sendKeys(Keys.ENTER);
    }
    @Step("Проверочка")
    public void assertionElement(){
        Assertions.assertTrue(driver.findElement((ExpectedEl)).isDisplayed());

    }
    @Step("Написать ремарку")
    public void createInRemarkText(){
        WebElement remark = driver.findElement(Remark);
        remark.click();
        remark.sendKeys(Text);
    }
    @Step("Написать имя")
    public void createInEmployerName() throws InterruptedException {
        WebElement typeForHints = driver.findElement(EmployeTypeForHints);
        WebElement create = driver.findElement(Create);
        typeForHints.click();
        typeForHints.sendKeys(NameEmployer);
        Thread.sleep(1000);
        typeForHints.click();
        Thread.sleep(1000);
        typeForHints.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        typeForHints.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        create.click();
    }
    @Step("Принять претензию")
    public void submitClaim(){
        WebElement submit = driver.findElement(Submit);
        submit.click();
        WebElement back = driver.findElement(Back);
        back.click();
    }
    @Step("Assert")
    public void assertAlice(){
        Assertions.assertTrue(driver.findElement(assertAlice).isDisplayed());
    }
}

