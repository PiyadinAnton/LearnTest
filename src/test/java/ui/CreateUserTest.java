package ui;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateUserTest extends TestBase {
    public static void create() throws InterruptedException {
        TestBase.setupApplication();
        TestBase.loginAgain();
        TestBase.createMan();
        TestBase.checkCreateMan();

        WebElement expectedElement = driver.findElement(By.xpath(PageObject.ExpectedElement));
        expectedElement.getText();
        Assertions.assertEquals(expectedElement.getText(), PageObject.ExpectedTextForAssertEquals);

        TestBase.closeApplication();
    }
}