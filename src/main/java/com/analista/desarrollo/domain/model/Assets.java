package com.analista.desarrollo.domain.model;

import com.analista.desarrollo.domain.validation.ArgumentValidation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Assets {
    private String serial;
    private String name;
    private LocalDate purchaseDate;
    private Double purchaseCost;
    private Double deprecation;
    private Boolean isEnabled;

    public Assets(String serial, String name, LocalDate purchaseDate, Double purchaseCost, Boolean isEnabled) {
        validations(serial, name, purchaseCost, purchaseDate);
        this.serial = serial;
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.purchaseCost = purchaseCost;
        this.isEnabled = isEnabled;
        deprecation = 0D;
    }

    private void validations(String serial, String name, Double purchaseCost, LocalDate purchaseDate) {
        ArgumentValidation.requiredValueValidation(serial, "Debe existir valor para el serial.");
        ArgumentValidation.requiredValueValidation(name, "Debe existir valor para el nombre.");
        ArgumentValidation.requiredValueValidation(purchaseCost, "Debe existir valor para el precio de compra.");
        ArgumentValidation.requiredValueValidation(purchaseDate, "Debe existir valor para la fecha de compra.");
        ArgumentValidation.requiredNotNegativeValueValidation(purchaseCost, "El precio de compra no puede ser negativo.");
    }

}
