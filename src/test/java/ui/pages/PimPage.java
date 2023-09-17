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
    public String URLPim = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
    static By Pim = By.cssSelector("ul li:nth-child(2) a");
    static By PimXpath = By.xpath("//div/div[1]/div/aside/nav/div[2]/ul/li[2]/a");
    static By Add = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    static By SearchFirstName =By.cssSelector( "[name=\"firstName\"]");
    static By SearchMiddleName = By.cssSelector("[name=\"middleName\"]");
    static By SearchLastName = By.cssSelector("[name=\"lastName\"]");
    static By Save = By.xpath("//*[@type=\"submit\"]");
    static By NameSearch = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input");
    static By Search = By.cssSelector("form [type=submit]");
    static String CreateFirstName = "Игорь";
    static String CreateMiddleName = "Иванов";
    static String CreateLastName = "Petrovich";
    static String ExpectedTextForAssertEquals = CreateFirstName + " " + CreateMiddleName;
    static By ExpectedElement = By.xpath("//*[@id=\"app\"]//*[@role=\"cell\"][3]//*");

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
    @Step ("Проверка ожидаемого элемента")
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
