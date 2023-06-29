package com.analista.desarrollo.domain.service;

import com.analista.desarrollo.domain.dataBuilder.AssetsTestDataBuilder;
import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.port.UpdateAssetsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class UpdateAssetsServiceTest {

    @Mock
    private UpdateAssetsRepository updateAssetsRepository;

    @InjectMocks
    private UpdateAssetsService updateAssetsService;

    @Test
    void updateAssetsSuccessTest() {
        String serial = "AAAA123";
        Assets assets = new AssetsTestDataBuilder()
                .withSerial(serial)
                .withEnable(true)
                .withPurchaseDate(LocalDate.of(2023, 1, 1))
                .withPurchaseCost(1200D)
                .withName("PC Mac Pro")
                .build();
        Mockito.when(updateAssetsRepository.execute(assets, serial)).thenReturn(assets);

        Assets newAssets = updateAssetsService.execute(assets, serial);

        Assertions.assertEquals(assets.getSerial(), newAssets.getSerial());
        Assertions.assertEquals(assets, newAssets);
    }
}