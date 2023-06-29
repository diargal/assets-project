package com.analista.desarrollo.infrastructure.adapter.persistence;

import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.port.CreateAssetsRepository;
import com.analista.desarrollo.infrastructure.adapter.persistence.entity.AssetsEntity;
import com.analista.desarrollo.infrastructure.adapter.persistence.mapper.AssetsEntityMapper;
import com.analista.desarrollo.infrastructure.adapter.persistence.repository.AssetsRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CreateAssetsPersistence implements CreateAssetsRepository {
    private final AssetsRepository assetsRepository;
    private final AssetsEntityMapper assetsEntityMapper;

    public CreateAssetsPersistence(AssetsRepository assetsRepository, AssetsEntityMapper assetsEntityMapper) {
        this.assetsRepository = assetsRepository;
        this.assetsEntityMapper = assetsEntityMapper;
    }

    @Override
    public Assets execute(Assets assets) {
        AssetsEntity assetsEntity = assetsEntityMapper.toEntity(assets);
        return assetsEntityMapper.toModel(assetsRepository.save(assetsEntity));
    }
}
