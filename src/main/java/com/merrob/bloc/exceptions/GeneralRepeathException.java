package com.merrob.bloc.exceptions;

public class GeneralRepeathException extends IllegalArgumentException {

    private static final String MESSAGE_ERROR = "You cannot repeat";

    public GeneralRepeathException() {
        super(MESSAGE_ERROR);
    }

    public GeneralRepeathException(String s) {
        super(MESSAGE_ERROR.concat(" : ").concat(s));
    }
}
