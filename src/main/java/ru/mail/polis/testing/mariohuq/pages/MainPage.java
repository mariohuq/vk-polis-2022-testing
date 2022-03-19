package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement profileLink = $(By.xpath("//*[contains(@class, 'nav-side')]//a[@data-l='t,userPage']"));

    public MainPage() {
        open("/");
    }

    public ProfilePage openProfile() {
        profileLink.click();
        return new ProfilePage();
    }
}
