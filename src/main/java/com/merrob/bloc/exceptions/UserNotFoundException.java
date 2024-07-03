package com.merrob.bloc.exceptions;

import jakarta.persistence.NoResultException;

public class UserNotFoundException extends NoResultException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}