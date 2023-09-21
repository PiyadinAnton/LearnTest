package ui;

import org.openqa.selenium.WebDriver;
import ui.helpers.WebDrivers;

public class TestBase extends WebDrivers {
    public String URL = "https://opensource-demo.orangehrmlive.com/";
    public String WayToScreen = "C:\\Users\\user\\IdeaProjects\\FinalHomework\\src\\test\\java\\ui\\helpers\\screen\\myscreenshot.png";
    public String Video = "https://www.youtube.com/watch?v=Llyp-bN-wBE&ab_channel=TESFAN";


    public void getUrl(WebDriver driver){
        driver.get(URL);
    }
}
