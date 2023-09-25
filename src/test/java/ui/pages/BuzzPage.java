package ui.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import ui.TestBase;

import static com.codeborne.selenide.Selenide.*;

public class BuzzPage extends TestBase {
    private final SelenideElement share = $x("(//*[@type='submit'])[2]");
    private final SelenideElement pasteVideo = $x("(//*[@id=\"app\"]//textarea)[3]");
    private final SelenideElement cssShare = $("button.oxd-glass-button:nth-child(2)");
    private final String video = "https://www.youtube.com/watch?v=Llyp-bN-wBE&ab_channel=TESFAN";

    @Story("Кликнуть на Share")
    public void setShare() {
        share.click();
    }

    @Story("Кликнуть на Share")
    public void setCssShare() throws InterruptedException {
        synchronized (cssShare) {
            cssShare.wait(1500);
        }
        cssShare.click();
    }

    @Story("Вставить ссылку на видео")
    public void setPasteVideo() throws InterruptedException {
        synchronized (pasteVideo) {
            pasteVideo.should(Condition.visible);
        }
        actions().moveToElement(pasteVideo).click().sendKeys(video).perform();

    }
}
