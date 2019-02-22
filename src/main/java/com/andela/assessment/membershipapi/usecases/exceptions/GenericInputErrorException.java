package com.andela.assessment.membershipapi.usecases.exceptions;

public class GenericInputErrorException extends Exception {
    public GenericInputErrorException(String message) {
        super(message);
    }
}
