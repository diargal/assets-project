package com.analista.desarrollo.infrastructure.adapter.persistence.mapper;

import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.infrastructure.adapter.persistence.entity.AssetsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AssetsEntityMapper {

    AssetsEntity toEntity(Assets assets);

    Assets toModel(AssetsEntity assetsEntity);

    //void update(Assets assetsOrigin, @MappingTarget Assets assetsFinal);
}
