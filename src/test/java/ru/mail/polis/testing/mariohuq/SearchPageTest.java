package ru.mail.polis.testing.mariohuq;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mail.polis.testing.mariohuq.pages.LoginPage;
import ru.mail.polis.testing.mariohuq.pages.SearchPage;
import ru.mail.polis.testing.mariohuq.utils.User;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.StringContains.containsString;
import static ru.mail.polis.testing.mariohuq.pages.SearchPage.SearchCategory.USERS;
import static ru.yandex.qatools.matchers.webdriver.TextMatcher.text;

public class SearchPageTest extends BaseWebTest {
    SearchPage searchPage;

    User user;

    @BeforeEach
    public void before() {
        user = User.fromProperties();
        new LoginPage().loginAs(user);
        searchPage = new SearchPage(USERS);
    }

    @ParameterizedTest
    @ValueSource(strings = {"technopolisbot7", "Ivan Novozhilov"})
    public void searchByNameInList(String candidate) {
        List<SelenideElement> items = searchPage.search(candidate).getSearchItems();
        assertThat("Search", items, hasItem(text(containsString(candidate))));
    }
}
