package ru.mail.polis.testing.mariohuq;

import org.junit.jupiter.api.Test;
import ru.mail.polis.testing.mariohuq.pages.MainPage;

public class OpenProfilePageTest extends BaseWebTest {

    @Test
    public void openProfilePage() {
        new MainPage()
                .openProfile()
                .shouldHaveUserName(USER.displayName());
    }
}
