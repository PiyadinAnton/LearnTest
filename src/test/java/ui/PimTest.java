package ui;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;
import ui.pages.LoginPage;
import ui.pages.PimPage;

public class PimTest extends WebDrivers {
    @Test
    @Description("Создать")
    public void createTest() throws InterruptedException {
        PimPage pimPage = new PimPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginVoid();
        pimPage.createMan();
        pimPage.checkCreateMan();
        pimPage.assertExpectedElement();
    }
}