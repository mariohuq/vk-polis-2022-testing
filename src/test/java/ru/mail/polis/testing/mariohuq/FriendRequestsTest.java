package ru.mail.polis.testing.mariohuq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mail.polis.testing.mariohuq.pages.FriendsPage;
import ru.mail.polis.testing.mariohuq.pages.LoginPage;
import ru.mail.polis.testing.mariohuq.pages.SearchPage;
import ru.mail.polis.testing.mariohuq.utils.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static ru.mail.polis.testing.mariohuq.pages.FriendsPage.FriendsCatalogTab.SENT_REQUEST;
import static ru.mail.polis.testing.mariohuq.pages.SearchPage.SearchCategory.USERS;

public class FriendRequestsTest extends BaseWebTest {

    private static final String TARGET_USER_NAME = "technopolisBot8";

    @BeforeEach
    public void before() {
        new LoginPage().loginAs(User.fromProperties());
        new SearchPage(USERS).search(TARGET_USER_NAME).addFriendFromSearch(TARGET_USER_NAME);
    }

    @Test
    public void removeFriend() {
        assertThat(is(new FriendsPage(SENT_REQUEST)
                .shouldHaveFriendRequestFrom(TARGET_USER_NAME)
                .removeRequest(TARGET_USER_NAME)), anything());
    }

}
