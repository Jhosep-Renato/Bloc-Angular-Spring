package com.merrob.bloc.exceptions.auth;

import jakarta.persistence.NoResultException;

public class UserNotFoundException extends NoResultException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}