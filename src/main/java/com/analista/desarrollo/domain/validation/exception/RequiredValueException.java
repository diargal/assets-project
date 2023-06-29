package com.analista.desarrollo.domain.validation.exception;

public class RequiredValueException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RequiredValueException(String message) {
        super(message);
    }
}
