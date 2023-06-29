package com.analista.desarrollo.domain.validation;

import com.analista.desarrollo.domain.validation.exception.RequiredDateAfterToOtherDateException;
import com.analista.desarrollo.domain.validation.exception.RequiredNotNegativeValueException;
import com.analista.desarrollo.domain.validation.exception.RequiredValueException;

import java.time.LocalDate;

public class ArgumentValidation {
    private ArgumentValidation() {
    }

    public static void requiredDateAfterToOtherDate(LocalDate initialDate, LocalDate finalDate, String message) {
        if (initialDate.isAfter(finalDate)) {
            throw new RequiredDateAfterToOtherDateException(message);
        }
    }

    public static void requiredValueValidation(Object value, String message) {
        if (value == null) {
            throw new RequiredValueException(message);
        }
    }

    public static void requiredNotNegativeValueValidation(Double value, String message) {
        if (value < 0) {
            throw new RequiredNotNegativeValueException(message);
        }
    }

}
