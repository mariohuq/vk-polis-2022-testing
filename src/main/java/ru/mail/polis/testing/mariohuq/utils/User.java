package ru.mail.polis.testing.mariohuq.utils;

import org.jetbrains.annotations.NotNull;

public record User(@NotNull String login, @NotNull String password, @NotNull String displayName) {
    public static User fromProperties() {
        return new User(
                System.getenv("ok.login"),
                System.getenv("ok.password"),
                System.getenv("ok.displayName")
        );
    }
}
