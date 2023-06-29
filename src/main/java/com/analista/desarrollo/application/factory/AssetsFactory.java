package com.analista.desarrollo.application.factory;

import com.analista.desarrollo.application.dto.AssetsRequestDto;
import com.analista.desarrollo.domain.model.Assets;
import org.springframework.stereotype.Component;

@Component
public class AssetsFactory {
    public Assets buildFull(AssetsRequestDto assetsRequestDto) {
        return new Assets(
                assetsRequestDto.getSerial(),
                assetsRequestDto.getName(),
                assetsRequestDto.getPurchaseDate(),
                assetsRequestDto.getPurchaseCost(),
                assetsRequestDto.getIsEnabled()
        );
    }
}
