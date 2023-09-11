package ui;

import org.junit.jupiter.api.Test;

public class UiTest {
    @Test
    public void findElementTest() {
        LoginAndLogout.findElementTest();
    }

    @Test
    public void loginTest() {
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