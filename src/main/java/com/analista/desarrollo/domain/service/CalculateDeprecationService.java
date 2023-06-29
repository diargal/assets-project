package com.analista.desarrollo.domain.service;

import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.port.FindAssetsRepository;
import com.analista.desarrollo.domain.validation.ArgumentValidation;

import java.time.LocalDate;
import java.time.Period;

public class CalculateDeprecationService {

    private final FindAssetsRepository findAssetsRepository;
    private static final String ERROR_MESSAGE = "La fecha actual no debe ser menor a la fecha de compra.";

    public CalculateDeprecationService(FindAssetsRepository findAssetsRepository) {
        this.findAssetsRepository = findAssetsRepository;
    }

    public Assets execute(LocalDate actualDate, Double deprecationPercentage, String serial) {
        Assets assets = findAssetsRepository.execute(serial);
        ArgumentValidation.requiredDateAfterToOtherDate(assets.getPurchaseDate(), actualDate, ERROR_MESSAGE);

        Period period = Period.between(assets.getPurchaseDate(), actualDate);
        int yearsDifference = period.getYears();
        Double deprecation = assets.getPurchaseCost() * yearsDifference * deprecationPercentage;
        assets.setDeprecation(deprecation);

        return assets;
    }

}
