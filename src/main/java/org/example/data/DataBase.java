package org.example.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.example.data.UserType.ADMIN;
import static org.example.data.UserType.CLIENT;

public final class DataBase {

    private static List<User> USERS = new ArrayList<>();
    private static List<Message> messages = Collections.synchronizedList(new ArrayList<>());

    private DataBase() {
    }

    public static Optional<User> findByLogin(String login) {
        return USERS.stream().filter(user -> user.getLogin().equals(login)).findFirst();
    }

    public static void init() {
        System.out.println("Установка соединения с Базой Данных");
        USERS.add(new User("Admin", "Admin", "Admin", ADMIN));
        USERS.add(new User("admin", "admin", "admin", ADMIN));
        USERS.add(new User("User1", "User1", "User1", CLIENT));
        USERS.add(new User("User2", "User2", "User2", CLIENT));
    }

    public static List<Message> getMessages() {
        return messages;
    }

    public static List<User> getUsers() {
        return USERS;
    }

    public static void addMessage(Message message) {
        messages.add(message);
    }

    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }

}
