package com.analista.desarrollo.domain.validation;

import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.validation.exception.RequiredNotNegativeValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class RequiredNotNegativeValueExceptionTest {

    @Test
    void purchaseCostNotNegative() {
        String errorMessage = "El precio de compra no puede ser negativo.";
        String serial = "455eedd";
        String name = "Mac pro";
        LocalDate purchaseDate = LocalDate.now();
        Double purchaseCost = -1000000D;
        Boolean isEnabled = true;

        try {
            new Assets(serial, name, purchaseDate, purchaseCost, isEnabled);
        } catch (RequiredNotNegativeValueException error) {
            Assertions.assertEquals(errorMessage, error.getMessage());
        }
    }
}
