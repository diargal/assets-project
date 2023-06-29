package com.analista.desarrollo.domain.dataBuilder;

import com.analista.desarrollo.domain.model.Assets;

import java.time.LocalDate;

public class AssetsTestDataBuilder {
    private Assets assets;

    public AssetsTestDataBuilder() {
        assets = new Assets();
    }

    public AssetsTestDataBuilder withSerial(String serial) {
        assets.setSerial(serial);
        return this;
    }

    public AssetsTestDataBuilder withName(String name) {
        assets.setName(name);
        return this;
    }

    public AssetsTestDataBuilder withPurchaseDate(LocalDate purchaseDate) {
        assets.setPurchaseDate(purchaseDate);
        return this;
    }

    public AssetsTestDataBuilder withPurchaseCost(Double purchaseCost) {
        assets.setPurchaseCost(purchaseCost);
        return this;
    }

    public AssetsTestDataBuilder withEnable(Boolean isEnabled) {
        assets.setIsEnabled(isEnabled);
        return this;
    }

    public AssetsTestDataBuilder fully() {
        assets = new Assets("QWAS213ED4", "PC Prueba",
                LocalDate.of(2020, 3, 19),
                1000000D,
                true
        );
        assets.setDeprecation(80000D);
        return this;
    }

    public Assets build() {
        return assets;
    }
}
