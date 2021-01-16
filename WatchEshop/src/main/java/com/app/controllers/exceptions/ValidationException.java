package com.app.controllers.exceptions;

import org.springframework.validation.Errors;

public class ValidationException extends RuntimeException {

    private final Errors errors;

    public ValidationException(Errors errors) {
        this.errors = errors;
    }

    public Errors getErrors() {
        return this.errors;
    }
}
