package com.merrob.bloc.exceptions.auth;

import com.merrob.bloc.dto.exception.AuthError;
import com.merrob.bloc.dto.exception.GeneralError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class AuthExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<AuthError> userRepeatHandlerException(UserRepeatException ex) {

        AuthError authError = new AuthError(BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(authError, BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<GeneralError> ioHandlerException(IOException ie) {

        GeneralError generalError = new GeneralError(NOT_FOUND.value(), ie.getMessage());
        return new ResponseEntity<>(generalError, NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<GeneralError> generalEmpty(NullPointerException ex) {

        GeneralError generalError = new GeneralError(BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(generalError, BAD_REQUEST);
    }
}
