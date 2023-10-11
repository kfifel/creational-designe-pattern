package com.pattern.builder;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    public static class UserBuilder {
        private Long id;
        private String name;
        private String email;
        private String password;

        public UserBuilder() {
        }

        public User build() {
            return new User(this);
        }

        public UserBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }
    }

    public User(UserBuilder userBuilder) {
        id = userBuilder.id;
        name = userBuilder.name;
        email = userBuilder.email;
        password = userBuilder.password;
    }
}
