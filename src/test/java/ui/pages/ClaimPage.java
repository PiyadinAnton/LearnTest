package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import ui.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class ClaimPage extends TestBase {
    private final String select = "[class='oxd-select-text-input']";
    private final SelenideElement selectVer2 = $x("//*[contains(text(), 'Select')][1]");

    private final SelenideElement claim = $x("//*[@href='/web/index.php/claim/viewClaimModule']");

    private final SelenideElement expectedEl = $x("//*[contains(text(), 'Accommodation')]");

    private final SelenideElement remark = $x("//*[@class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]");

    private final SelenideElement assign = $x("//*[@class=\"orangehrm-header-container\"]//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");

    private final SelenideElement employerTypeForHints = $x("//*[@placeholder=\"Type for hints...\"]");

    private final SelenideElement create = $x("//*[@type=\"submit\"]");
    private final SelenideElement submit = $x("//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-sm-button\"]");
    private final SelenideElement back = $x("//*[@class=\"oxd-button oxd-button--medium oxd-button--ghost orangehrm-sm-button\"]");

    private final SelenideElement assertName = $x("//*[contains(text(), 'Maggie Manning')]");
    private final String nameEmployer = "Maggie Manning";
    private final String text = "Random text";

    private final SelenideElement listbox = $x("//*[@role='listbox')");

    @Step("Создать Claim")
    public void claimAssign() {
        claim.click();
        assign.click();
    }

    @Step("Выбрать 2 опцию")
    public void selectV2() {
        ElementsCollection elements = $$(select);
        SelenideElement element = elements.get(1);
        actions()
                .moveToElement(element)
                .click()
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    @Step("Выбрать 1 опцию")
    public void selectV1() {
        selectVer2.shouldBe(Condition.visible);
        actions()
                .moveToElement(selectVer2)
                .click()
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    @Step("Написать ремарку")
    public void createInRemarkText() {
        synchronized (remark) {
            remark.shouldBe(Condition.visible);
        }
        remark.sendKeys(text);
    }

    @Step("Написать имя")
    public void createInEmployerName() throws InterruptedException {
        employerTypeForHints.click();
        employerTypeForHints.sendKeys(nameEmployer);
        Thread.sleep(1500);
        employerTypeForHints.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    @Step("Создать")
    public void submitClaimStep1() {
        create.should(Condition.visible);
        create.click();
    }
    @Step("Создать")
    public void submitClaimStep2() {
        synchronized (submit) {
            submit.shouldBe(Condition.visible,Duration.ofSeconds(5));
            submit.click();
        }
    }
    @Step("Создать")
    public void submitClaimStep3() {
        back.should(Condition.visible);
        back.click();
    }

    @Step("Assert")
    public void setAssertName() {
        assertName.shouldBe(Condition.visible);
        Assert.assertTrue(assertName.isDisplayed());
    }
}

