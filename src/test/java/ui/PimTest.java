package ui;

import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.helpers.WebDrivers;
import ui.pages.LoginPage;
import ui.pages.PimPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Listeners({ScreenShooter.class})
public class PimTest extends PimPage {
    @Epic("Проверка сайта ORANGEHRM")
    @Feature("Проверка функицонала страниц")
    @Test
    @Story("Создание сотрудника во вкладке PIM")
    @Description("Создать")
    @Severity(CRITICAL)
    public void createTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginVoid();
        super.createMan();
        super.checkCreateMan();
        super.assertExpectedElement();
    }
}