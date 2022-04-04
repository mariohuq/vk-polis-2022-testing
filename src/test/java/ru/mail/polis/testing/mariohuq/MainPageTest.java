package ru.mail.polis.testing.mariohuq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mail.polis.testing.mariohuq.pages.LoginPage;
import ru.mail.polis.testing.mariohuq.pages.MainPage;
import ru.mail.polis.testing.mariohuq.utils.User;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Condition.text;

public class MainPageTest extends BaseWebTest {
    MainPage mainPage;

    @BeforeEach
    public void before() {
        open("/");
        mainPage = new LoginPage().loginAs(User.fromProperties());
    }

    @Test
    public void openProfilePage() {
        mainPage
                .openProfilePage()
                .shouldHave(p -> p.userNameHeader, text(User.fromProperties().displayName()));
    }

    @Test
    public void switchToRecommendationsTab() {
        mainPage
                .switchToRecommendationsTab()
                .shouldHave(p -> p.feedPostsHideLinks, sizeNotEqual(0));
    }
}
