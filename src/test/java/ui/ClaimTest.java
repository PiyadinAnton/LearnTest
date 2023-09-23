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
        claimPage.selectV2();
        claimPage.createInEmployerName();
        claimPage.selectAccommodation();
        claimPage.createInRemarkText();
        claimPage.submitClaim();
        claimPage.assertAlice();
        claimPage.assertionElement();
    }
}
