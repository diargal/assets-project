package com.analista.desarrollo.infrastructure.controller.handler;

import com.analista.desarrollo.domain.validation.exception.AssetsNotFoundException;
import com.analista.desarrollo.domain.validation.exception.RequiredDateAfterToOtherDateException;
import com.analista.desarrollo.domain.validation.exception.RequiredNotNegativeValueException;
import com.analista.desarrollo.domain.validation.exception.RequiredValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CreditControllerHandler {

    @ExceptionHandler
    private ResponseEntity<Object> sendResponse(Exception exception) {

        if (exception instanceof AssetsNotFoundException) {

            return new ResponseEntity<>(exception.toString(), HttpStatus.NOT_FOUND);

        } else if (exception instanceof RequiredDateAfterToOtherDateException ||
                exception instanceof RequiredNotNegativeValueException ||
                exception instanceof RequiredValueException) {

            return new ResponseEntity<>(exception.toString(), HttpStatus.BAD_REQUEST);

        } else {
            return new ResponseEntity<>(exception.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
