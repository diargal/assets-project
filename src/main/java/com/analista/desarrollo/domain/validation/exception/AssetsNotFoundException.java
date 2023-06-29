package com.analista.desarrollo.domain.validation.exception;

public class AssetsNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AssetsNotFoundException(String message) {
        super(message);
    }
}
