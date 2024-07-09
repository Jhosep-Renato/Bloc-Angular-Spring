package com.merrob.bloc.exceptions.auth;

import jakarta.persistence.EntityExistsException;

public class UserRepeatException extends EntityExistsException {

    private static final String MESSAGE_ERROR = "The user exists in db";

    public UserRepeatException() {
        super(MESSAGE_ERROR);
    }

    public UserRepeatException(String message) {
        super(message);
    }
}
