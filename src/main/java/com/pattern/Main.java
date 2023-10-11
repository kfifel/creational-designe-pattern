package com.pattern;

import com.pattern.Singleton.DataBaseSingleton;
import com.pattern.builder.User;

import java.sql.Connection;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        User user =
            new User
                .UserBuilder()
                .setId(1L)
                .setEmail("khalid@gmail.com")
                .setName("khlaid fifel")
                .setPassword("password")
                .build();
    }
}