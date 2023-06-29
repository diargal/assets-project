package com.analista.desarrollo.application.handler;

import com.analista.desarrollo.application.dto.AssetsRequestDto;
import com.analista.desarrollo.application.dto.AssetsResponseDto;
import com.analista.desarrollo.application.factory.AssetsFactory;
import com.analista.desarrollo.application.mapper.AssetsMapper;
import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.service.UpdateAssetsService;
import org.springframework.stereotype.Component;

@Component
public class UpdateAssetsHandler {
    private final UpdateAssetsService updateAssetsService;
    private final AssetsFactory assetsFactory;
    private final AssetsMapper assetsMapper;

    public UpdateAssetsHandler(UpdateAssetsService updateAssetsService, AssetsFactory assetsFactory, AssetsMapper assetsMapper) {
        this.updateAssetsService = updateAssetsService;
        this.assetsFactory = assetsFactory;
        this.assetsMapper = assetsMapper;
    }

    public AssetsResponseDto execute(AssetsRequestDto assetsRequestDto, String serial) {
        Assets assets = assetsFactory.buildFull(assetsRequestDto);
        Assets assets1 = updateAssetsService.execute(assets, serial);

        return assetsMapper.toDto(assets1);
    }
}
