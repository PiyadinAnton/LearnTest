package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;
import ui.pages.ClaimPage;
import ui.pages.LoginPage;

public class ClaimTest extends WebDrivers {
    @Test
    @Description("Тыкаем")
    public void claimTest(){
        LoginPage loginPage = new LoginPage(driver);
        ClaimPage claimPage = new ClaimPage(driver);
        loginPage.loginVoid();
        claimPage.claimAssignAndSelect();
    }
}
