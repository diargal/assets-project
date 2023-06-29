package com.analista.desarrollo.domain.validation;

import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.validation.exception.RequiredValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class RequiredValueExceptionTest {

    @Test
    void requiredValueToPurchaseCostTest() {
        String errorMessage = "Debe existir valor para el precio de compra.";
        String serial = "455eedd";
        String name = "Mac pro";
        LocalDate purchaseDate = LocalDate.now();
        Double purchaseCost = null;
        Boolean isEnabled = true;

        try {
            new Assets(serial, name, purchaseDate, purchaseCost, isEnabled);
        } catch (RequiredValueException error) {
            Assertions.assertEquals(errorMessage, error.getMessage());
        }
    }

    @Test
    void requiredValueToSerialTest() {
        String errorMessage = "Debe existir valor para el serial.";
        String serial = null;
        String name = "Mac pro";
        LocalDate purchaseDate = LocalDate.now();
        Double purchaseCost = 100000D;
        Boolean isEnabled = true;

        try {
            new Assets(serial, name, purchaseDate, purchaseCost, isEnabled);
        } catch (RequiredValueException error) {
            Assertions.assertEquals(errorMessage, error.getMessage());
        }
    }

    @Test
    void requiredValueToNameTest() {
        String errorMessage = "Debe existir valor para el nombre.";
        String serial = "RTYAU45";
        String name = null;
        LocalDate purchaseDate = LocalDate.now();
        Double purchaseCost = 100000D;
        Boolean isEnabled = true;

        try {
            new Assets(serial, name, purchaseDate, purchaseCost, isEnabled);
        } catch (RequiredValueException error) {
            Assertions.assertEquals(errorMessage, error.getMessage());
        }
    }

    @Test
    void requiredValueToPurchaseDateTest() {
        String errorMessage = "Debe existir valor para la fecha de compra.";
        String serial = "RTYAU45";
        String name = "Mac pro";
        LocalDate purchaseDate = null;
        Double purchaseCost = 100000D;
        Boolean isEnabled = true;

        try {
            new Assets(serial, name, purchaseDate, purchaseCost, isEnabled);
        } catch (RequiredValueException error) {
            Assertions.assertEquals(errorMessage, error.getMessage());
        }
    }
}
