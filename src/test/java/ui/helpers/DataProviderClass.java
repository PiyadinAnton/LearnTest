package ui.helpers;
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

public class DataProviderClass {
    static String WayToScreen = "C:\\Games\\screenshot\\myscreenshot.png";
    public static String Video = "https://www.youtube.com/watch?v=Llyp-bN-wBE&ab_channel=TESFAN";
    static String CreateFirstName = "Игорь";
    static String CreateMiddleName = "Иванов";
    static String CreateLastName = "Petrovich";
}
