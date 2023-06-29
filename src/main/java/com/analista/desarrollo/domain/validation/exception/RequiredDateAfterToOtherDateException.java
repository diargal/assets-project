package com.analista.desarrollo.domain.validation.exception;

public class RequiredDateAfterToOtherDateException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RequiredDateAfterToOtherDateException(String message) {
        super(message);
    }
}
