package ru.mail.polis.testing.mariohuq;

import org.junit.jupiter.api.Test;
import ru.mail.polis.testing.mariohuq.pages.MainPage;
import ru.mail.polis.testing.mariohuq.pages.ProfilePage;

import java.nio.charset.StandardCharsets;

public class OpenProfilePageTest extends BaseWebTest {

    private static final String USERNAME = "Михаил Палыч";

    @Test
    public void openProfilePage() {
        ProfilePage profile = new MainPage().openProfile();
        assertEquals(USERNAME, profile.getUserName());
    }
}
