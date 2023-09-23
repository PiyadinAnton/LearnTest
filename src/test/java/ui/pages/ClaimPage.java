package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import ui.TestBase;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;

public class ClaimPage extends TestBase {
    private final SelenideElement select = $x("//*[contains(text(), 'Select')][1]");
    private final SelenideElement selectVer2 = $x("//*[@id=\"app\"]//*/*[1]/div[2]/*/div[2]/*/div[1]");

    private final SelenideElement claim = $x("//*[@href='/web/index.php/claim/viewClaimModule']");

    private final SelenideElement expectedEl = $x("//*[contains(text(), 'Accommodation')]");

    private final SelenideElement remark = $x("//*[@class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]");

    private final SelenideElement assign = $x("//*[@class=\"orangehrm-header-container\"]//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");

    private final SelenideElement employerTypeForHints = $x("//*[@placeholder=\"Type for hints...\"]");

    private final SelenideElement create = $x("//*[@type=\"submit\"]");
    private final SelenideElement submit = $x("//*[@type=\"button\" and @class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-sm-button\"]");
    private final SelenideElement back = $x("//*[@class=\"oxd-button oxd-button--medium oxd-button--ghost orangehrm-sm-button\"]");

    private final SelenideElement assertAlice = $x("//*[contains(text(), 'Alice Duval')]");
    private final String nameEmployer = "Alice  Duval";
    private final String text = "Random text";

    @Step("Создать Claim")
    public void claimAssign() throws InterruptedException {
        claim.click();
        assign.click();
    }

    @Step("Создать")
    public void selectAccommodation() throws InterruptedException {
        select.shouldBe(Condition.visible);
        select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    public void selectV2() {
        selectVer2.shouldBe(Condition.visible);
        selectVer2.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    }

    @Step("Проверочка")
    public void assertionElement() {
        expectedEl.shouldBe(Condition.visible);
        Assert.assertTrue(expectedEl.isDisplayed());

    }

    @Step("Написать ремарку")
    public void createInRemarkText() throws InterruptedException {
        synchronized (remark) {
            remark.shouldBe(Condition.visible);
        }
        remark.sendKeys(text);
    }

    @Step("Написать имя")
    public void createInEmployerName() throws InterruptedException {
        employerTypeForHints.click();
        employerTypeForHints.sendKeys(nameEmployer);
        Thread.sleep(1000);
        employerTypeForHints.click();
        Thread.sleep(1000);
        employerTypeForHints.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        employerTypeForHints.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        create.click();
    }

    @Step("Принять претензию")
    public void submitClaim() {
        submit.shouldBe(Condition.visible);
        submit.click();
        back.shouldBe(Condition.visible);
        back.click();
    }

    @Step("Assert")
    public void assertAlice() {
        Assert.assertTrue(assertAlice.isDisplayed());
    }
}

