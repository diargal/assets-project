package com.analista.desarrollo.application.mapper;

import com.analista.desarrollo.application.dto.AssetsResponseDto;
import com.analista.desarrollo.domain.model.Assets;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AssetsMapper {
    AssetsResponseDto toDto(Assets assets);
}
