package ui.helpers;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDrivers {

    public WebDriver driver;

    public void open() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(Locators.URL);
    }

    public void close() {
        driver.quit();
    }

}
