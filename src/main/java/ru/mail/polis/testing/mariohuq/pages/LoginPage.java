package ru.mail.polis.testing.mariohuq.pages;

import org.openqa.selenium.By;
import ru.mail.polis.testing.mariohuq.utils.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static final By LOGIN_INPUT = By.xpath("//input[@data-l='t,login']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@data-l='t,password']");
    private static final By LOGIN_BUTTON = By.xpath("//input[@data-l='t,sign_in']");

    public LoginPage() {
        open("/");
    }

    public MainPage loginAs(User user) {
        $(LOGIN_INPUT).setValue(user.login());
        $(PASSWORD_INPUT).setValue(user.password());
        $(LOGIN_BUTTON).click();
        return new MainPage();
    }
}
