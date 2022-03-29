package ru.mail.polis.testing.mariohuq;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Нужно добавить переменные окружения. Пример:
 * <p>
 * ok.login=78005553535;ok.password=12345678QWERTY;ok.displayName=Михаил Палыч
 * <p>
 * в IDEA: Edit configurations... > Run > Environment variables
 */
public class BaseWebTest {
    private static final String BASE_URL = "https://ok.ru";

    @BeforeAll
    public static void configure() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browser = "chrome";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1280x1024";
    }

    protected static void open(String url) {
        Selenide.open(url);
    }

    @BeforeEach
    public void resetDriver() {
        Selenide.closeWebDriver();
    }
}
