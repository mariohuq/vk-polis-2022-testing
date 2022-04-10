package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage implements CheckablePage<SearchPage> {

    private final static ElementsCollection menuButtons = $$(By.xpath("//*[contains(@class,'tabs-redesign')]//li[contains(@class, 'menu-button')]"));
    private final static SelenideElement searchTextField = $(By.xpath("//*[contains(@class, 'search-content')]//input"));
    private final static ElementsCollection searchList = $$(By.xpath("//*[contains(@class, 'portal-search-island')]//*[contains(@class,'row')]//*[contains(@class,'card-caption')]"));

    public SearchPage() {
        open("/search");
    }

    public SearchPage(SearchCategory tab) {
        this();
        switchToTab(tab);
    }

    public SearchPage switchToTab(SearchCategory tab) {
        tab.categoryButton.click();
        return this;
    }

    public SearchPage search(String name) {
        searchTextField.setValue(name);
        searchTextField.pressEnter(); // кнопки для слабых
        return this;
    }

    public SelenideElement getSearchItem(int index) {
        return searchList.get(index);
    }

    public ElementsCollection getSearchItems() {
        try {Thread.sleep(1000);} catch (Exception e) {}
        return searchList;
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
    }

}
