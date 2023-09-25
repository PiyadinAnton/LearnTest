package ui;

import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;
import ui.pages.ClaimPage;
import ui.pages.LoginPage;
@Listeners({ScreenShooter.class})
public class ClaimTest extends WebDrivers {
    @Test
    @Description("Тыкаем")
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
