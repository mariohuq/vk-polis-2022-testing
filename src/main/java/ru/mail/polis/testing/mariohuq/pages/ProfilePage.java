package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage implements BasePage<ProfilePage> {
    private final SelenideElement userProfileName = $(By.xpath("//a[@class='profile-user-info_name']/h1"));

    public ProfilePage(){
        //validate();
    }

    public String getUserName() {
        return userProfileName.text();
    }

    @Override
    public ProfilePage validate() {
        if (!userProfileName.isDisplayed()) {
            throw new RuntimeException(this.getClass().getName());
        }
        return this;
    }
}
