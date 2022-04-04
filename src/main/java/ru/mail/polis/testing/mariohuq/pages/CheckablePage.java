package ru.mail.polis.testing.mariohuq.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

import java.util.function.Function;

public interface CheckablePage<P extends CheckablePage<P>> {
    @CanIgnoreReturnValue
    default P shouldHave(Function<P, SelenideElement> selector, Condition condition) {
        P that = (P) this;
        selector.apply(that).should(condition);
        return that;
    }

    @CanIgnoreReturnValue
    default P shouldHave(Function<P, ElementsCollection> selector, CollectionCondition condition) {
        P that = (P) this;
        selector.apply(that).should(condition);
        return that;
    }
}
