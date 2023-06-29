package com.analista.desarrollo.application.handler;

import com.analista.desarrollo.application.dto.AssetsRequestDto;
import com.analista.desarrollo.application.dto.AssetsResponseDto;
import com.analista.desarrollo.application.factory.AssetsFactory;
import com.analista.desarrollo.application.mapper.AssetsMapper;
import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.service.CreateAssetsService;
import org.springframework.stereotype.Component;

@Component
public class CreateAssetsHandler {
    private final CreateAssetsService createAssetsService;
    private final AssetsFactory assetsFactory;
    private final AssetsMapper assetsMapper;

    public CreateAssetsHandler(CreateAssetsService createAssetsService, AssetsFactory assetsFactory, AssetsMapper assetsMapper) {
        this.createAssetsService = createAssetsService;
        this.assetsFactory = assetsFactory;
        this.assetsMapper = assetsMapper;
    }

    public AssetsResponseDto execute(AssetsRequestDto assetsRequestDto) {
        Assets asset = assetsFactory.buildFull(assetsRequestDto);
        Assets assets = createAssetsService.execute(asset);

        return assetsMapper.toDto(assets);

    }
}
