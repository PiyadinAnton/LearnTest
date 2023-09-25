package ui;

import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;
import ui.pages.LoginPage;
import ui.pages.PimPage;
@Listeners({ScreenShooter.class})
public class PimTest extends WebDrivers {
    @Test
    @Description("Создать")
    public void createTest() throws InterruptedException {
        PimPage pimPage = new PimPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginVoid();
        pimPage.createMan();
        pimPage.checkCreateMan();
        pimPage.assertExpectedElement();
    }
}