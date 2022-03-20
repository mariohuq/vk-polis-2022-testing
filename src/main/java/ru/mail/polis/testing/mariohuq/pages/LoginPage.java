package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.mail.polis.testing.mariohuq.utils.User;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage implements BasePage<LoginPage> {
    private final SelenideElement loginField = $(By.xpath("//input[@data-l='t,login']"));

    private final SelenideElement passwordField = $(By.xpath("//input[@data-l='t,password']"));

    private final SelenideElement loginButton = $(By.xpath("//input[@data-l='t,sign_in']"));

    public LoginPage() {
        open("/");
        validate();
    }

    public MainPage login(User user) {
        loginField.setValue(user.login());
        passwordField.setValue(user.password());
        loginButton.click();
        MainPage page;
        try {
            page = new MainPage();
        }
        catch(Exception e) {
            throw new RuntimeException("Unable to login");
        }
        return page;
    }

    @Override
    public LoginPage validate() {
        if (!loginButton.isDisplayed()) {
            throw new RuntimeException(this.getClass().getName());
        }
        return this;
    }
}
