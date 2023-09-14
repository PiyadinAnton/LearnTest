package ui;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.io.IOException;

public class UiTest {
    @Test
    @Description("Поиск элемента")
    public void findElementTest() throws InterruptedException, IOException {
        LoginAndLogout.findElementTest();
    }

    @Test
    @Description("Логин")
    public void loginTest() throws InterruptedException, IOException {
        LoginAndLogout.login();
    }

    @Test
    @Description("Разлогин")
    public void logoutTest() {
        LoginAndLogout.logOut();
    }

    @Test
    @Description("Создать")
    public void createTest() throws InterruptedException {
        CreateUserTest.create();
    }

    @Test
    @Description("Уронить тест для отправки скриншота")
    public void specNotLoginTest() throws InterruptedException, IOException {
        LoginAndLogout.desLogin();
    }

    @Test
    @Description("JSСкрипт")
    public void forJSQuest() throws IOException, InterruptedException {
        LoginAndLogout.jSTest();
    }

    @Test
    @Description("Негативный")
    public void fakeLoginTest() throws IOException, InterruptedException {
        LoginAndLogout.fakeLogin();
    }

    @Test
    @Description("Поделиться видео")
    public void shareVideoTest() throws IOException, InterruptedException {
        CreateUserTest.createPost();
    }
}