package ui;


import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class PageObject {
    static String URL = "https://opensource-demo.orangehrmlive.com/";
    static String Login = "Admin";
    static String FakeLogin = "aaa";
    static String FakePassword = "bbb";
    static String Password = "admin123";
    static String LoginInput = "[name='username']";
    static String PasswordInput = "[name='password']";
    static String LoginButton = "//div/button";
    static String Menu = "//div//p[@class='oxd-userdropdown-name']";
    static String LogoutButton = "//div//a[@href=\"/web/index.php/auth/logout\"]";
    static String FindName = "//div//h6";
    static String Pim = "ul li:nth-child(2) a";
    static String Buzz = "ul li:nth-child(12) a";
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
    static String InvalidCredentials = "//div[contains(@class, 'oxd-alert-content')]";
    static String CssShare = "button.oxd-glass-button:nth-child(2)";
    static String PasteVideo = "(//*[@id=\"app\"]//textarea)[3]";
    static String Share = "(//*[@type='submit'])[2]";

    static String Video = "https://www.youtube.com/watch?v=Llyp-bN-wBE&ab_channel=TESFAN";

    public static WebDriver driver;

    @BeforeTest
    public static void setupApplication() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(PageObject.URL);
    }

    public static void closeApplication() {
        driver.quit();
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

    public static void assertLoginName(){
        WebElement loginElement = driver.findElement(By.xpath(PageObject.FindName));
        Assertions.assertTrue(loginElement.isDisplayed());
    }
    public static void assertLoginButton(){
        WebElement loginElement = driver.findElement(By.xpath(PageObject.LoginButton));
        Assertions.assertTrue(loginElement.isDisplayed());
    }
    public static void assertInvalidCredentials(){
        WebElement loginElement = driver.findElement(By.xpath(PageObject.InvalidCredentials));
        Assertions.assertTrue(loginElement.isDisplayed());}

    public static void expectedScreenshot() throws IOException, InterruptedException {
        Thread.sleep(1500);//слишком быстро грузится страница
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
    public static void takeScreenshot(WebDriver driver) throws InterruptedException,IOException {
        Thread.sleep(1500); //слишком быстро грузится страница
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshotBytes));
    }
    public static void setShare() {
        WebElement sharePost = driver.findElement(By.xpath(PageObject.Share));
        sharePost.click();
    }

    public static void setBuzz(){
        WebElement buzz = driver.findElement(By.cssSelector(PageObject.Buzz));
        buzz.click();
    }
    public static void setCssShare(){
        WebElement share = driver.findElement(By.cssSelector(PageObject.CssShare));
        share.click();}
    public static void setPasteVideo(){
        WebElement paste = driver.findElement(By.xpath(PageObject.PasteVideo));
        paste.click();
        paste.sendKeys(PageObject.Video);}

}

