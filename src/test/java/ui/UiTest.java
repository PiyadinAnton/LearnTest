package ui;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class UiTest {
    @Test
    public void findElementTest() throws InterruptedException, IOException {
        LoginAndLogout.findElementTest();
    }
    @Test
    public void loginTest() throws InterruptedException {
        LoginAndLogout.login();
    }

    @Test
    public void logoutTest() {
        LoginAndLogout.logOut();
    }

    @Test
    public void createTest() throws InterruptedException {
        CreateUserTest.create();
    }
}