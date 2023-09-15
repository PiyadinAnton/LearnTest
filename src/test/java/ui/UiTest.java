package ui;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.io.IOException;

import static ui.BuzzTest.createPost;
import static ui.DashboardTest.*;
import static ui.LoginTest.*;
import static ui.PimTest.createTestVoid;

public class UiTest {

    @Test
    @Description("Поиск элемента")
    public void finderElementTest() throws InterruptedException, IOException {
        findElementTestVoid();
    }

    @Test
    @Description("Логин")
    public void loginTest() throws InterruptedException, IOException {
        loginTestVoid();
    }

    @Test
    @Description("Разлогин")
    public void logoutTest() throws IOException, InterruptedException {
        logoutTestVoid();
    }

    @Test
    @Description("Создать")
    public void createTest() throws InterruptedException, IOException {
        createTestVoid();
    }

    @Test
    @Description("Уронить тест для отправки скриншота")
    public void specNotLoginTest() throws InterruptedException, IOException {
        downTestVoid();
    }

    @Test
    @Description("JSСкрипт")
    public void forJSQuestTest() throws IOException, InterruptedException {
        forJSFindElementVoid();
        scrollDashboardVoid();
        outPrintAndClosedVoid();
    }

    @Test
    @Description("Негативный")
    public void fakeLoginTest() throws IOException, InterruptedException {
        fakeLoginTestVoid();
    }

    @Test
    @Description("Поделиться видео")
    public void shareVideoTest() throws IOException, InterruptedException {
        createPost();
    }
}