package ui;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;
import ui.pages.ClaimPage;
import ui.pages.LoginPage;

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
