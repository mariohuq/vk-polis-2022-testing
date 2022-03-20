package ru.mail.polis.testing.mariohuq;

import org.junit.jupiter.api.Test;
import ru.mail.polis.testing.mariohuq.pages.MainPage;
import ru.mail.polis.testing.mariohuq.pages.ProfilePage;

public class OpenProfilePageTest extends BaseWebTest {

    private static final String USERNAME = "Михаил Палыч";

    @Test
    public void openProfilePage() {
        ProfilePage profile = new MainPage().openProfile();
        profile.shouldHaveUserName(USERNAME);
    }
}
