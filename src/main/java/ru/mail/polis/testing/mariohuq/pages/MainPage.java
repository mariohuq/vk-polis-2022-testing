package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage implements CheckablePage<MainPage> {
    private final SelenideElement profileLink = $(By.xpath("//a[@data-l='t,userPage']"));
    private final SelenideElement recommendationsLink = $(By.xpath("//a[@href='/dk?cmd=MainFeedsWrapper&st.f.block=MainFeedsContent&st.f.filterGroupId=43&st.cmd=userMain&st._aid=Feed_Filter']"));

    public final ElementsCollection feedPostsHideLinks = $$(By.xpath("//*[@class='feed-w']//a[@class='feed_close']"));

    public ProfilePage openProfilePage() {
        profileLink.click();
        return new ProfilePage();
    }

    public MainPage switchToRecommendationsTab() {
        recommendationsLink.click();
        return this;
    }
}

