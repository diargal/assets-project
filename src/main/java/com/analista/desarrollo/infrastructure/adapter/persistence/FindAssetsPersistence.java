package com.analista.desarrollo.infrastructure.adapter.persistence;

import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.port.FindAssetsRepository;
import com.analista.desarrollo.domain.validation.exception.AssetsNotFoundException;
import com.analista.desarrollo.infrastructure.adapter.persistence.entity.AssetsEntity;
import com.analista.desarrollo.infrastructure.adapter.persistence.mapper.AssetsEntityMapper;
import com.analista.desarrollo.infrastructure.adapter.persistence.repository.AssetsRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FindAssetsPersistence implements FindAssetsRepository {
    private final AssetsRepository assetsRepository;
    private final AssetsEntityMapper assetsEntityMapper;
    private static final String NOT_FOUND = "No se encontró registro con el serial ingresado";

    public FindAssetsPersistence(AssetsRepository assetsRepository, AssetsEntityMapper assetsEntityMapper) {
        this.assetsRepository = assetsRepository;
        this.assetsEntityMapper = assetsEntityMapper;
    }

    @Override
    public Assets execute(String serial) {
        AssetsEntity assetsEntity = assetsRepository.findById(serial).orElseThrow(() -> new AssetsNotFoundException(NOT_FOUND));

        return assetsEntityMapper.toModel(assetsEntity);
    }
}
