package ui;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.io.IOException;

import static ui.LoginTest.*;
import static ui.TestBase.*;
import static ui.pages.LoginPage.desLogin;

public class UiTest {

    @Test
    @Description("Поиск элемента")
    public void findElementTest() throws InterruptedException, IOException {
        findElementTest();
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
    public void createTest() throws InterruptedException {
        create();
    }

    @Test
    @Description("Уронить тест для отправки скриншота")
    public void specNotLoginTest() throws InterruptedException, IOException {
        desLogin();
    }

    @Test
    @Description("JSСкрипт")
    public void forJSQuestTest() throws IOException, InterruptedException {
        jSTest();
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