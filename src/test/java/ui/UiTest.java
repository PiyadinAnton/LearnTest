package ui;

import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.pages.LogPage;

import java.io.IOException;
import java.util.Random;

import static ui.BuzzTest.createPost;
import static ui.DashboardTest.*;
import static ui.LoginTest.*;
import static ui.PimTest.createTestVoid;
import static ui.helpers.WebDriverContainer.closeApplication;
import static ui.helpers.WebDriverContainer.setupApplication;

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
    @Test
    @Description("Рандом")
    public void randomDataTest() throws IOException, InterruptedException {


        System.out.println(generateRandomString());
        closeApplication();

    }
}