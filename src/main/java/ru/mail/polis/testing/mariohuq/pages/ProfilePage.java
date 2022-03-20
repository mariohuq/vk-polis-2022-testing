package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    private final SelenideElement userProfileName = $(By.xpath("//a[@class='profile-user-info_name']/h1"));

    public String getUserName() {
        return userProfileName.text();
    }
}
