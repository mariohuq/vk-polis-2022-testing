package ru.mail.polis.testing.mariohuq;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import ru.mail.polis.testing.mariohuq.pages.LoginPage;
import ru.mail.polis.testing.mariohuq.utils.User;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

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

    public static void assertEquals(String o1, String o2) {
        Assertions.assertEquals(o1, o2);
    }

    // на случай приколов с кодировкой типа РњРёС…Р°РёР» РџР°Р»С‹С‡
    public static String prayToUTF_8(String o1){
        try {
            return new String(o1.getBytes("windows-1251"), StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
