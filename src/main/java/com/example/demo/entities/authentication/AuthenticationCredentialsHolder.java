package com.example.demo.entities.authentication;

import lombok.Getter;

public class AuthenticationCredentialsHolder {
    @Getter
    private final String email;
    @Getter
    private final String password;

    private static AuthenticationCredentialsHolder credentialsHolder;

    private AuthenticationCredentialsHolder(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static AuthenticationCredentialsHolder getCredentialsHolder() {
        return credentialsHolder;
    }

    public static AuthenticationCredentialsHolder setCredentialsHolder(String email, String password) {
        credentialsHolder = new AuthenticationCredentialsHolder(email, password);
        return credentialsHolder;
    }
}
