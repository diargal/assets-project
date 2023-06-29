package com.analista.desarrollo.domain.dataBuilder;

import com.analista.desarrollo.application.dto.AssetsRequestDto;

import java.time.LocalDate;

public class AssetsRequestTestDataBuilder {
    private AssetsRequestDto assets;

    public AssetsRequestTestDataBuilder() {
        assets = new AssetsRequestDto();
    }

    public AssetsRequestTestDataBuilder withSerial(String serial) {
        assets.setSerial(serial);
        return this;
    }

    public AssetsRequestTestDataBuilder withName(String name) {
        assets.setName(name);
        return this;
    }

    public AssetsRequestTestDataBuilder withPurchaseDate(LocalDate purchaseDate) {
        assets.setPurchaseDate(purchaseDate);
        return this;
    }

    public AssetsRequestTestDataBuilder withPurchaseCost(Double purchaseCost) {
        assets.setPurchaseCost(purchaseCost);
        return this;
    }

    public AssetsRequestTestDataBuilder withEnable(Boolean isEnabled) {
        assets.setIsEnabled(isEnabled);
        return this;
    }

    public AssetsRequestTestDataBuilder fully() {
        assets = new AssetsRequestDto("QWAS213ED4", "PC Prueba",
                LocalDate.of(2020, 3, 19),
                1000000D,
                true
        );
        return this;
    }

    public AssetsRequestDto build() {
        return assets;
    }
}
