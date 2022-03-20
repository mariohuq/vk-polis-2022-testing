package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage implements BasePage<MainPage> {

    private final SelenideElement profileLink = $(By.xpath("//*[contains(@class, 'nav-side')]//a[@data-l='t,userPage']"));

    public MainPage() {
        validate();
    }

    public ProfilePage openProfile() {
        profileLink.click();
        return new ProfilePage();
    }

    @Override
    public MainPage validate() {
        if (!profileLink.isDisplayed()) {
            throw new RuntimeException(this.getClass().getName());
        }
        return this;
    }
}
