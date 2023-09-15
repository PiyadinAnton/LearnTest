package ui;

import java.io.IOException;

import static ui.TestBase.login;
import static ui.helpers.ScreenshotListener.takeScreenshot;
import static ui.helpers.WebDriverContainer.*;
import static ui.pages.BuzzPage.*;
import static ui.pages.DashboardPage.setBuzz;
public class BuzzTest {
    public static void createPost() throws IOException, InterruptedException {
        setupApplication();
        login();
        setBuzz();
        Thread.sleep(3000); //неявные ожидания не ждут, пришлось так
        setCssShare();
        Thread.sleep(3000);
        setPasteVideo();
        Thread.sleep(3000);
        setShare();
        Thread.sleep(3000);
        takeScreenshot(driver);
        closeApplication();
    }
}
