package com.analista.desarrollo.domain.service;

import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.port.CreateAssetsRepository;

public class CreateAssetsService {
    private final CreateAssetsRepository createAssetsRepository;

    public CreateAssetsService(CreateAssetsRepository createAssetsRepository) {
        this.createAssetsRepository = createAssetsRepository;
    }

    public Assets execute(Assets assets) {
        return createAssetsRepository.execute(assets);
    }
}
