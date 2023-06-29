package com.analista.desarrollo.domain.service;

import com.analista.desarrollo.domain.dataBuilder.AssetsTestDataBuilder;
import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.port.CreateAssetsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class CreateAssetsServiceTest {

    @Mock
    private CreateAssetsRepository assetsRepository;

    @InjectMocks
    private CreateAssetsService createAssetsService;

    @Test
    void createAssetsSuccessTest() {
        Assets assets = new AssetsTestDataBuilder()
                .withSerial("AAAA123")
                .withEnable(true)
                .withPurchaseDate(LocalDate.of(2023, 1, 1))
                .withPurchaseCost(1200D)
                .withName("PC Mac Pro")
                .build();
        Mockito.when(assetsRepository.execute(assets)).thenReturn(assets);

        Assets newAssets = createAssetsService.execute(assets);

        Assertions.assertEquals(assets.getSerial(), newAssets.getSerial());
    }
}