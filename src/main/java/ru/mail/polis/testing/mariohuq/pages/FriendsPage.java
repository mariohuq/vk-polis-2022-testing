package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static ru.mail.polis.testing.mariohuq.pages.FriendsPage.FriendsCatalogTab.SENT_REQUEST;

public class FriendsPage implements CheckablePage<FriendsPage> {
    private final static ElementsCollection menuButtons =
            $$(By.xpath("//*[@id='UserFriendsCatalogRB']//a[contains(@class,'nav-side')]"));
    private final static ElementsCollection friendRequestsCaptions =
            $$(By.xpath("//*[@id='listBlockPanelOutgoingFriendshipRequests']//*[contains(@class,'portlet_b')]//*[contains(@class,'caption')]"));

    private final static By cancelRequest = By.xpath(".//span[contains(@class,'js-entity-decline button-pro')]");
    private final static By requestName = By.xpath(".//a[contains(@class,'o')]");

    public FriendsPage() {
        open("/friends");
    }

    public FriendsPage(FriendsCatalogTab tab) {
        this();
        switchToTab(tab);
    }

    public FriendsPage switchToTab(FriendsCatalogTab tab) {
        tab.switchTo();
        return this;
    }

    public FriendsPage shouldHaveFriendRequestFrom(String name) {
        validateRemoveRequest();
        friendRequestsCaptions.shouldHave(CollectionCondition.anyMatch("Friend request",
                (p -> p.getText().contains(name))
        ));
        return this;
    }

    public FriendsPage removeRequest(String name) {
        validateRemoveRequest();
        for (SelenideElement friendRequest : friendRequestsCaptions) {
            if (friendRequest.find(requestName).text().contains(name)) {
                friendRequest.find(cancelRequest).click();
                break;
            }
        }
        return this;
    }

    public FriendsPage removeFirstRequest() {
        validateRemoveRequest();
        friendRequestsCaptions.first().find(cancelRequest).click();
        return this;
    }

    private void validateRemoveRequest() {
        if (!SENT_REQUEST.isSelected()) {
            throw new RuntimeException("Invalid page");
        }

        if (friendRequestsCaptions.size() == 0) {
            throw new RuntimeException("Empty list");
        }
    }

    public enum FriendsCatalogTab {
        ALL(menuButtons.get(0)),
        ONLINE(menuButtons.get(1)),
        FRIEND_REQUEST(menuButtons.get(2)),
        MAY_KNOW(menuButtons.get(3)),
        SENT_REQUEST(menuButtons.get(4)),
        CATEGORIES(menuButtons.get(5));

        private final SelenideElement categoryButton;

        FriendsCatalogTab(SelenideElement btn) {

            this.categoryButton = btn;
        }

        public boolean isSelected() {
            return Objects.requireNonNull(this.categoryButton.getAttribute("class")).contains("__ac");
        }

        public void switchTo() {
            categoryButton.click();
            this.categoryButton.shouldHave(Condition.attributeMatching("class", ".*__ac.*"));
        }
    }

}
