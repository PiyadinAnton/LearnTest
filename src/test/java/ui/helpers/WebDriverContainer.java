package ui.helpers;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import ui.PageObject;

import java.time.Duration;

public class WebDriverContainer {
    public static WebDriver driver;

    @BeforeTest
    public static void setupApplication() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Locators.URL);
    }

    public static void closeApplication() {
        driver.quit();
    }
}
