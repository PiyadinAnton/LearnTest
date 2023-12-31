package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import ui.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class PimPage extends TestBase {


    private final SelenideElement pim = $("ul li:nth-child(2) a");
    private final SelenideElement pimXpath = $x("//a[@class='oxd-main-menu-item active']");
    private final SelenideElement add = $x("//button[contains(@class, 'oxd-button--secondary') and @type='button']");
    private final SelenideElement searchFirstName = $("[name=\"firstName\"]");
    private final SelenideElement searchMiddleName = $("[name=\"middleName\"]");
    private final SelenideElement searchLastName = $("[name=\"lastName\"]");
    private final SelenideElement save = $x("//*[@type=\"submit\"]");
    private final SelenideElement nameSearch = $x("//*[@placeholder='Type for hints...'][1]");
    private final SelenideElement search = $("form [type=submit]");
    private final SelenideElement expectedElement = $x("//*[@id=\"app\"]//*[@role=\"cell\"][3]//*");
    private final String createFirstName = "Игорь";
    private final String createMiddleName = "Иванов";
    private final String createLastName = "Petrovich";
    private final String expectedTextForAssertEquals = createFirstName + " " + createMiddleName;

    @Step("Клик на Pim")
    public void forCheckPim() {
        pimXpath.click();
    }

    @Step("Клик для поиска имени")
    public void forNameSearchClick() {
        nameSearch.click();
        nameSearch.sendKeys(createFirstName);
    }

    @Step("Клик на Search")
    public void forThreadSearchElement() throws InterruptedException {
        synchronized (search) {
            search.wait(1600);
            search.click();
        }
    }

    @Step("Клик на Add")
    public void setAddXpath() {
        synchronized (add) {
            add.should(Condition.visible);
            add.click();
        }
    }

    @Step("Создать ФИО")
    public void setFindName() {
        searchFirstName.click();
        searchFirstName.sendKeys(createFirstName);
        searchMiddleName.click();
        searchMiddleName.sendKeys(createMiddleName);
        searchLastName.click();
        searchLastName.sendKeys(createLastName);
        save.click();
    }

    @Step("Клик на Pim")
    public void setPimCss() {
        pim.click();
    }

    @Step("Создание нового сотрудника")
    public void createMan() {
        setPimCss();
        setAddXpath();
        setFindName();
    }

    @Step("Проверка ожидаемого элемента")
    public void assertExpectedElement() {
        Assert.assertEquals(expectedElement.getText(), expectedTextForAssertEquals);
    }

    @Step("Проверка созданного сотрудника")
    public void checkCreateMan() throws InterruptedException {
        PimPage pimPage = new PimPage();
        pimPage.forCheckPim();
        pimPage.forNameSearchClick();
        pimPage.forThreadSearchElement();
    }
}
