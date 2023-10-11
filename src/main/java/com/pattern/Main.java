package com.pattern;

import com.pattern.builder.User;
public class Main {
    public static void main(String[] args) {


    // use the builder pattern to create a user object
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