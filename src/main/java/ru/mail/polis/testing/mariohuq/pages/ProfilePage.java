package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    public final SelenideElement userNameHeader = $(By.xpath("//a[@class='profile-user-info_name']"));
}
