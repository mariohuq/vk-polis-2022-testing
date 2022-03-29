package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement sideNavigation = $(By.xpath("//*[contains(@class, 'nav-side')]"));
    private final SelenideElement profileLink = sideNavigation.$(By.xpath("a[@data-l='t,userPage']"));

    public ProfilePage openProfilePage() {
        profileLink.click();
        return new ProfilePage();
    }
}
