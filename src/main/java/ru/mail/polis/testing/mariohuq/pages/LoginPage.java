package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.mail.polis.testing.mariohuq.utils.User;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement loginField = $(By.xpath("//input[@data-l='t,login']"));

    private final SelenideElement passwordField = $(By.xpath("//input[@data-l='t,password']"));

    private final SelenideElement loginButton = $(By.xpath("//input[@data-l='t,sign_in']"));

    public LoginPage() {
        open("/");
    }

    public MainPage login(User user) {
        loginField.setValue(user.login());
        passwordField.setValue(user.password());
        loginButton.click();
        return new MainPage();
    }
}
