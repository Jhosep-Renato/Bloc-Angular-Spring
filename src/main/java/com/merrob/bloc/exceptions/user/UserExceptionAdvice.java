package com.merrob.bloc.exceptions.user;

import com.merrob.bloc.dto.exception.GeneralError;
import com.merrob.bloc.exceptions.GeneralRepeathException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<GeneralError> repeatedSections(GeneralRepeathException ex) {

        GeneralError generalError = new GeneralError(HttpStatus.CONFLICT.value(), ex.getMessage());
        return new ResponseEntity<>(generalError, HttpStatus.CONFLICT);
    }
}
