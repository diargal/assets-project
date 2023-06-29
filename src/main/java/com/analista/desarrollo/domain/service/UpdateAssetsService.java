package com.analista.desarrollo.domain.service;

import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.port.UpdateAssetsRepository;

public class UpdateAssetsService {
    private final UpdateAssetsRepository updateAssetsRepository;

    public UpdateAssetsService(UpdateAssetsRepository updateAssetsRepository) {
        this.updateAssetsRepository = updateAssetsRepository;
    }

    public Assets execute(Assets assets, String serial) {
        return updateAssetsRepository.execute(assets, serial);
    }
}
