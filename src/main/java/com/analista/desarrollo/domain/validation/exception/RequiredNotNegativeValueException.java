package com.analista.desarrollo.domain.validation.exception;

public class RequiredNotNegativeValueException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RequiredNotNegativeValueException(String message) {
        super(message);
    }
}
