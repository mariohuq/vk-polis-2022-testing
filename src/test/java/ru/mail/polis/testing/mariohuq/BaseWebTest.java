package ru.mail.polis.testing.mariohuq;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;

public class BaseWebTest {

    @BeforeAll
    public static void openOk() {
        timeout = 10000;
        baseUrl = "https://ok.ru";
        browser = "chrome";
        browserPosition = "890x10";
        browserSize = "1080x950";
        open("/");
    }

    @AfterAll
    public static void closeOk() {
        closeWebDriver();
    }
}
