package ru.mail.polis.testing.mariohuq;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.mail.polis.testing.mariohuq.pages.LoginPage;
import ru.mail.polis.testing.mariohuq.utils.User;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;

public class BaseWebTest {

    private static final User USER = new User("88005553535", "password");

    @BeforeAll
    public static void openOk() {
        timeout = 10000;
        baseUrl = "https://ok.ru";
        browser = "chrome";
        browserPosition = "0x0";
        browserSize = "1280x1024";
        login();
    }

    @AfterAll
    public static void closeOk() {
        closeWebDriver();
    }

    protected static void login() {
        new LoginPage().login(USER);
    }
}
