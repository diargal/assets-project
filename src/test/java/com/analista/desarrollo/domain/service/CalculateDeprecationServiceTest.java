package com.analista.desarrollo.domain.service;

import com.analista.desarrollo.domain.dataBuilder.AssetsTestDataBuilder;
import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.port.FindAssetsRepository;
import com.analista.desarrollo.domain.validation.exception.RequiredDateAfterToOtherDateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class CalculateDeprecationServiceTest {

    @Mock
    private FindAssetsRepository findAssetsRepository;
    @InjectMocks
    private CalculateDeprecationService calculateDeprecationService;

    @Test
    void calculateDeprecationSuccessTest() {
        String serial = "45ER3455";
        Double cost = 1000000D;
        Assets assets = new AssetsTestDataBuilder().withSerial(serial).withPurchaseDate(LocalDate.of(2023, 1, 1)).withPurchaseCost(cost).build();
        LocalDate actualDate = LocalDate.of(2025, 1, 1);
        Double deprecationPercentage = 0.04D;
        Mockito.when(findAssetsRepository.execute(serial)).thenReturn(assets);
        Double deprecationExpected = 80000D;

        assets = calculateDeprecationService.execute(actualDate, deprecationPercentage, serial);

        Assertions.assertEquals(deprecationExpected, assets.getDeprecation());
    }

    @Test
    void calculateDeprecationDateErrorTest() {
        String serial = "45ER3455";
        Double cost = 1000000D;
        Assets assets = new AssetsTestDataBuilder().withSerial(serial).withPurchaseDate(LocalDate.of(2023, 1, 1)).withPurchaseCost(cost).build();
        LocalDate actualDate = LocalDate.of(2022, 1, 1);
        Double deprecationPercentage = 0.04D;
        Mockito.when(findAssetsRepository.execute(serial)).thenReturn(assets);
        String errorMessage = "La fecha actual no debe ser menor a la fecha de compra.";

        try {
            calculateDeprecationService.execute(actualDate, deprecationPercentage, serial);
        } catch (RequiredDateAfterToOtherDateException error) {
            Assertions.assertEquals(errorMessage, error.getMessage());
        }
    }
}