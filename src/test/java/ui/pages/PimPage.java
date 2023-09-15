package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static ui.helpers.WebDriverContainer.driver;

public class PimPage {
    public String URLPim = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
    static String PimXpath = "//div/div[1]/div/aside/nav/div[2]/ul/li[2]/a";
    static String Add = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button";
    static String SearchFirstName = "[name=\"firstName\"]";
    static String SearchMiddleName = "[name=\"middleName\"]";
    static String SearchLastName = "[name=\"lastName\"]";
    static String Save = "//*[@type=\"submit\"]";
    static String NameSearch = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input";
    static String Search = "form [type=submit]";
    static String CreateFirstName = "Игорь";
    static String CreateMiddleName = "Иванов";
    static String CreateLastName = "Petrovich";
    public static String ExpectedTextForAssertEquals = CreateFirstName + " " + CreateMiddleName;
    public static void forCheckPim() {
        WebElement pimAgain = driver.findElement(By.xpath(PimXpath));
        pimAgain.click();
    }
    public static void forNameSearchClick() {
        WebElement nameSearch = driver.findElement(By.xpath(NameSearch));
        nameSearch.click();
        nameSearch.sendKeys(CreateFirstName);
    }
    public static void forThreadSearchElement() throws InterruptedException {
        Thread.sleep(2000);// неявное ожидание ждёт появление не того элемента (тут нужен)
        WebElement search = driver.findElement(By.cssSelector(Search));
        search.click();
    }
    public static void setAddXpath() {
        WebElement add = driver.findElement(By.xpath(Add));
        add.click();
    }
    public static void setFindName() {
        WebElement firstName = driver.findElement(By.cssSelector(SearchFirstName));
        WebElement middleName = driver.findElement(By.cssSelector(SearchMiddleName));
        WebElement lastName = driver.findElement(By.cssSelector(SearchLastName));
        WebElement save = driver.findElement(By.xpath(Save));

        firstName.sendKeys(CreateFirstName);
        middleName.click();
        middleName.sendKeys(CreateMiddleName);
        lastName.click();
        lastName.sendKeys(CreateLastName);
        save.click();
    }
}
