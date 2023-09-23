package ui.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.TestBase;


public class PimPage extends TestBase {
    private WebDriver driver;

    public PimPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By Pim = By.cssSelector("ul li:nth-child(2) a");
    private final By PimXpath = By.xpath("//a[@class='oxd-main-menu-item active']");
    private final By Add = By.xpath("//button[contains(@class, 'oxd-button--secondary') and @type='button']");
    private final By SearchFirstName = By.cssSelector("[name=\"firstName\"]");
    private final By SearchMiddleName = By.cssSelector("[name=\"middleName\"]");
    private final By SearchLastName = By.cssSelector("[name=\"lastName\"]");
    private final By Save = By.xpath("//*[@type=\"submit\"]");
    private final By NameSearch = By.xpath("//*[@placeholder='Type for hints...'][1]");
    private final By Search = By.cssSelector("form [type=submit]");
    private final String CreateFirstName = "Игорь";
    private final String CreateMiddleName = "Иванов";
    private final String CreateLastName = "Petrovich";
    private final String ExpectedTextForAssertEquals = CreateFirstName + " " + CreateMiddleName;
    private final By ExpectedElement = By.xpath("//*[@id=\"app\"]//*[@role=\"cell\"][3]//*");

    public void forCheckPim() {
        WebElement pimAgain = driver.findElement((PimXpath));
        pimAgain.click();
    }

    public void forNameSearchClick() {
        WebElement nameSearch = driver.findElement(NameSearch);
        nameSearch.click();
        nameSearch.sendKeys(CreateFirstName);
    }

    public void forThreadSearchElement() throws InterruptedException {
        Thread.sleep(2000);// неявное ожидание ждёт появление не того элемента (тут нужен)
        WebElement search = driver.findElement(Search);
        search.click();
    }

    public void setAddXpath() {
        WebElement add = driver.findElement(Add);
        add.click();
    }

    public void setFindName() {
        WebElement firstName = driver.findElement(SearchFirstName);
        WebElement middleName = driver.findElement(SearchMiddleName);
        WebElement lastName = driver.findElement(SearchLastName);
        WebElement save = driver.findElement(Save);
        firstName.click();
        firstName.sendKeys(CreateFirstName);
        middleName.click();
        middleName.sendKeys(CreateMiddleName);
        lastName.click();
        lastName.sendKeys(CreateLastName);
        save.click();
    }

    public void setPimCss() {
        driver.findElement((Pim)).click();
    }

    @Step("Создание нового сотрудника")
    public void createMan() {
        setPimCss();
        setAddXpath();
        setFindName();
    }

    @Step("Проверка ожидаемого элемента")
    public void assertExpectedElement() {
        Assertions.assertEquals(driver.findElement((ExpectedElement)).getText(), ExpectedTextForAssertEquals);
    }

    @Step("Проверка созданного сотрудника")
    public void checkCreateMan() throws InterruptedException {
        PimPage pimPage = new PimPage(driver);
        pimPage.forCheckPim();
        pimPage.forNameSearchClick();
        pimPage.forThreadSearchElement();
    }
}
