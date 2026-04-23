package user;

import utils.PropertyReader;

public class UserFactory {

    private UserFactory() {
    }

    public static User withCorrectData() {
        return new User(
                PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.password")
        );
    }

    public static User withLockedPermission() {
        return new User(
                PropertyReader.getProperty("saucedemo.locked_user"),
                PropertyReader.getProperty("saucedemo.password")
        );
    }

    public static User withIncorrectPermission() {
        return new User(
                PropertyReader.getProperty("saucedemo.incorrect_user"),
                PropertyReader.getProperty("saucedemo.password")
        );
    }

    public static User withEmptyPagePermission() {
        return new User("", "");
    }
}