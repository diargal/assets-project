package com.analista.desarrollo.infrastructure.adapter.persistence;

import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.port.UpdateAssetsRepository;
import com.analista.desarrollo.infrastructure.adapter.persistence.entity.AssetsEntity;
import com.analista.desarrollo.infrastructure.adapter.persistence.mapper.AssetsEntityMapper;
import com.analista.desarrollo.infrastructure.adapter.persistence.repository.AssetsRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateAssetsPersistence implements UpdateAssetsRepository {
    private final AssetsRepository assetsRepository;
    private final AssetsEntityMapper assetsEntityMapper;
    private final FindAssetsPersistence findAssetsPersistence;

    public UpdateAssetsPersistence(AssetsRepository assetsRepository, AssetsEntityMapper assetsEntityMapper, FindAssetsPersistence findAssetsPersistence) {
        this.assetsRepository = assetsRepository;
        this.assetsEntityMapper = assetsEntityMapper;
        this.findAssetsPersistence = findAssetsPersistence;
    }


    @Override
    public Assets execute(Assets assets, String serial) {
        findAssetsPersistence.execute(serial);
        assets.setSerial(serial);
        AssetsEntity assetsEntity = assetsEntityMapper.toEntity(assets);

        return assetsEntityMapper.toModel(assetsRepository.save(assetsEntity));
    }

    private void verifyValuesToChange(Assets assetsFound, Assets assetsRequest){
        //if(assetsRequest.getPurchaseCost())
    }
}
