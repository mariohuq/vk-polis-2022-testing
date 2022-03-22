package ru.mail.polis.testing.mariohuq;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.mail.polis.testing.mariohuq.pages.LoginPage;
import ru.mail.polis.testing.mariohuq.utils.User;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

/**
 * Нужно добавить переменные окружения. Пример:
 *
 * ok.login=78005553535;ok.password=12345678QWERTY;ok.displayName=Михаил Палыч
 *
 * в IDEA: Edit configurations... > Run > Environment variables
 */
public class BaseWebTest {

    protected static final User USER = User.fromProperties();

    @BeforeAll
    public static void openOk() {
        timeout = 10000;
        baseUrl = "https://ok.ru";
        browser = "chrome";
        browserPosition = "0x0";
        browserSize = "1280x1024";
        new LoginPage().login(USER);
    }

    @AfterAll
    public static void closeOk() {
        closeWebDriver();
    }
}
