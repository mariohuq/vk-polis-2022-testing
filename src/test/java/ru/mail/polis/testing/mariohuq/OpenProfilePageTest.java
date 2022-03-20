package ru.mail.polis.testing.mariohuq;

import org.junit.jupiter.api.Test;
import ru.mail.polis.testing.mariohuq.pages.ProfilePage;

public class OpenProfilePageTest extends BaseWebTest {

    @Test
    public void openProfilePage() {
        ProfilePage profile = mainPage.openProfile();
        profile.shouldHaveUserName(USER.displayName());
    }
}
