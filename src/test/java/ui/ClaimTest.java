package ui;

import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;
import ui.pages.ClaimPage;
import ui.pages.LoginPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Listeners({ScreenShooter.class})
public class ClaimTest extends WebDrivers {
    @Epic("Проверка сайта ORANGEHRM")
    @Feature("Проверка функицонала страниц")
    @Test
    @Story("Проверка создания претензии (Claim)")
    @Description("Тыкаем")
    @Severity(CRITICAL)
    public void claimTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        ClaimPage claimPage = new ClaimPage();
        loginPage.loginVoid();
        claimPage.claimAssign();
        claimPage.createInEmployerName();
        claimPage.selectV2();
        claimPage.createInRemarkText();
        claimPage.selectV1();
        claimPage.submitClaimStep1();
        claimPage.submitClaimStep2();
        claimPage.submitClaimStep3();
        claimPage.setAssertName();
    }
}
