package ui;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Attachment;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class PageObject {
    static String URL = "https://opensource-demo.orangehrmlive.com/";
    static String Login = "Admin";
    static String Password = "admin123";
    static String LoginInput = "[name='username']";
    static String PasswordInput = "[name='password']";
    static String LoginButton = "//div/button";
    static String Menu = "//div//p[@class='oxd-userdropdown-name']";
    static String LogoutButton = "//div//a[@href=\"/web/index.php/auth/logout\"]";
    static String FindName = "//div//h6";
    static String Pim = "ul li:nth-child(2) a";
    static String PimXpath = "//div/div[1]/div/aside/nav/div[2]/ul/li[2]/a";
    static String Add = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button";
    static String SearchFirstName = "[name=\"firstName\"]";
    static String SearchMiddleName = "[name=\"middleName\"]";
    static String SearchLastName = "[name=\"lastName\"]";
    static String Save = "//*[@type=\"submit\"]";
    static String NameSearch = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input";
    static String Search = "form [type=submit]";
    static String CreateFirstName = "Игорь";
    static String CreateMiddleName = "Иванов";
    static String CreateLastName = "Petrovich";
    static String ExpectedElement = "//*[@id=\"app\"]//*[@role=\"cell\"][3]//*";
    static String ExpectedTextForAssertEquals = PageObject.CreateFirstName + " " + PageObject.CreateMiddleName;
    static String WayToScreen = "C:\\Games\\screenshot\\myscreenshot.png";

    public static WebDriver driver;

    @BeforeAll
    public static void setupApplication() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get(PageObject.URL);
    }

    public static void closeApplication() {
        driver.quit();
    }

    public static void loginAgain() {
        WebElement loginInput = driver.findElement(By.cssSelector(PageObject.LoginInput));
        WebElement passwordInput = driver.findElement(By.cssSelector(PageObject.PasswordInput));
        WebElement loginButton = driver.findElement(By.xpath(PageObject.LoginButton));
        loginInput.click();
        loginInput.sendKeys(PageObject.Login);
        passwordInput.click();
        passwordInput.sendKeys(PageObject.Password);
        loginButton.click();
    }

    public static void setMenuButton() {
        WebElement menu = driver.findElement(By.xpath(PageObject.Menu));
        menu.click();
    }

    public static void setLogoutButton() {
        WebElement logout = driver.findElement(By.xpath(PageObject.LogoutButton));
        logout.click();
    }

    public static void setPimCss() {
        WebElement pim = driver.findElement(By.cssSelector(PageObject.Pim));
        pim.click();
    }

    public static void setAddXpath() {
        WebElement add = driver.findElement(By.xpath(PageObject.Add));
        add.click();
    }

    public static void setFindName() {
        WebElement firstName = driver.findElement(By.cssSelector(PageObject.SearchFirstName));
        WebElement middleName = driver.findElement(By.cssSelector(PageObject.SearchMiddleName));
        WebElement lastName = driver.findElement(By.cssSelector(PageObject.SearchLastName));
        WebElement save = driver.findElement(By.xpath(PageObject.Save));

        firstName.sendKeys(PageObject.CreateFirstName);
        middleName.click();
        middleName.sendKeys(PageObject.CreateMiddleName);
        lastName.click();
        lastName.sendKeys(PageObject.CreateLastName);
        save.click();
    }

    public static void forCheckPim() {
        WebElement pimAgain = driver.findElement(By.xpath(PageObject.PimXpath));
        pimAgain.click();
    }

    public static void forNameSearchClick() {
        WebElement nameSearch = driver.findElement(By.xpath(PageObject.NameSearch));
        nameSearch.click();
        nameSearch.sendKeys(PageObject.CreateFirstName);
    }

    public static void forThreadSearchElement() throws InterruptedException {
        Thread.sleep(2000);// неявное ожидание ждёт появление не того элемента (тут нужен)
        WebElement search = driver.findElement(By.cssSelector(PageObject.Search));
        search.click();
    }

    public static void testElementPresence() {
        driver.get(PageObject.URL);
        driver.findElement(By.cssSelector(PageObject.LoginInput)).isDisplayed();
    }

    public static void expectedScreenshot() throws IOException, InterruptedException {
        Thread.sleep(1500);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage screenshotImage = ImageIO.read(screenshotFile);
        File expectedScreenshotFile = new File(WayToScreen);
        BufferedImage expectedScreenshotImage = ImageIO.read(expectedScreenshotFile);
        boolean isIdentical = compareImages(screenshotImage, expectedScreenshotImage);
        if (isIdentical) {
            System.out.println("Скриншоты идентичны.");
        } else {
            System.out.println("Скриншоты отличаются.");
        }
    }

    private static boolean compareImages(BufferedImage image1, BufferedImage image2) {
        if (image1.getWidth() != image2.getWidth() || image1.getHeight() != image2.getHeight()) {
            return false;
        }
        for (int x = 0; x < image1.getWidth(); x++) {
            for (int y = 0; y < image1.getHeight(); y++) {
                if (image1.getRGB(x, y) != image2.getRGB(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void takeScreenshot() throws InterruptedException {
        // Сделать снимок экрана с помощью WebDriver
        Thread.sleep(1500); //слишком быстро грузится страница
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);
        // Добавить снимок экрана в отчет Allure
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshotBytes));
    }
}

