package ui.helpers;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import static ui.helpers.DataClass.WayToScreen;
import static ui.helpers.WebDriverContainer.driver;

public class ScreenshotListener {
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
    @Step("Отрпавка скриншота для подтверждения теста")
    public static void takeScreenshot(WebDriver driver) throws InterruptedException, IOException {
        Thread.sleep(1500); //слишком быстро грузится страница
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshotBytes));
    }
}
