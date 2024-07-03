package com.merrob.bloc.exceptions;

import com.merrob.bloc.dto.AuthError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class AuthExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<AuthError> userRepeatHandlerException(UserRepeatException ex) {

        AuthError authError = new AuthError(BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(authError, BAD_REQUEST);
    }
}
