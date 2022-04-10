package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static ru.mail.polis.testing.mariohuq.pages.SearchPage.SearchCategory.USERS;

public class SearchPage implements CheckablePage<SearchPage> {

    private final static ElementsCollection menuButtons = $$(By.xpath("//*[contains(@class,'tabs-redesign')]//li[contains(@class, 'menu-button')]"));
    private final static SelenideElement headerField = $(By.xpath("//*[contains(@class, 'island_header')]"));
    private final static SelenideElement searchTextField = $(By.xpath("//*[contains(@class, 'search-content')]//input"));

    private final static ElementsCollection peopleNamesList = $$(By.xpath("//*[contains(@class, 'portal-search-island')]//*[contains(@class,'row')]//*[contains(@class,'card-caption')]"));

    private final static ElementsCollection peopleSearchList = $$(By.xpath("//*[contains(@class, 'portal-search-island')]//*[contains(@class,'card')]"));
    private final static By peopleNameField = By.xpath(".//*[contains(@class,'card-caption')]");
    private final static By peopleAddFriendButton = By.xpath(".//button[contains(@class,'button')]");

    private final static String headerStart = "Возможно, вы знакомы";

    public SearchPage() {
        open("/search");
    }

    public SearchPage(SearchCategory tab) {
        this();
        switchToTab(tab);
    }

    public SearchPage switchToTab(SearchCategory tab) {
        tab.switchTo();
        return this;
    }

    public SearchPage search(String name) {
        searchTextField.setValue(name);
        searchTextField.pressEnter(); // кнопки для слабых
        headerField.shouldNotHave(text(headerStart));
        return this;
    }

    public SelenideElement getSearchItem(int index) {
        return peopleNamesList.get(index);
    }

    public ElementsCollection getSearchItems() {
        return peopleNamesList;
    }

    public SearchPage addFriendFromSearch(String name) {
        validateAddRequest();

        for (SelenideElement selenideElement : peopleSearchList) {
            if (selenideElement.find(peopleNameField).text().contains(name)) {
                ElementsCollection root = selenideElement.findAll(peopleAddFriendButton);
                if (!root.isEmpty()) {
                    root.first().click();
                }
                return this;
            }
        }

        return this;
    }

    private void validateAddRequest() {
        if (!USERS.isSelected()) {
            throw new RuntimeException("Invalid page");
        }

        if (peopleSearchList.size() == 0) {
            throw new RuntimeException("Empty list");
        }
    }

    public enum SearchCategory {

        USERS(menuButtons.get(0)),
        PUBLICATIONS(menuButtons.get(1)),
        GROUPS(menuButtons.get(2)),
        MUSIC(menuButtons.get(3)),
        VIDEO(menuButtons.get(4)),
        GAMES(menuButtons.get(5));

        private final SelenideElement categoryButton;

        SearchCategory(SelenideElement btn) {
            this.categoryButton = btn;
        }

        public boolean isSelected() {
            return this.categoryButton.getAttribute("class").contains("__active");
        }

        public void switchTo() {
            categoryButton.click();
            this.categoryButton.shouldHave(Condition.attributeMatching("class", ".*__active.*"));
        }
    }

}
