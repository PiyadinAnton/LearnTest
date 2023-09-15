package ui;

import java.io.IOException;

import static ui.TestBase.*;
import static ui.helpers.WebDriverContainer.closeApplication;
import static ui.helpers.WebDriverContainer.setupApplication;

public class PimTest {
    public static void createTestVoid() throws InterruptedException, IOException {
        setupApplication();
        login();
        createMan();
        checkCreateMan();
        assertCheckExpectedElementVoid();
        closeApplication();
    }
}

