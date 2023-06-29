package com.analista.desarrollo.application.handler;

import com.analista.desarrollo.application.dto.AssetsResponseDto;
import com.analista.desarrollo.application.dto.DeprecationDto;
import com.analista.desarrollo.application.mapper.AssetsMapper;
import com.analista.desarrollo.domain.service.CalculateDeprecationService;
import org.springframework.stereotype.Component;

@Component
public class CalculateDeprecationHandler {
    private final CalculateDeprecationService calculateDeprecationService;
    private final AssetsMapper assetsMapper;

    public CalculateDeprecationHandler(CalculateDeprecationService calculateDeprecationService, AssetsMapper assetsMapper) {
        this.calculateDeprecationService = calculateDeprecationService;
        this.assetsMapper = assetsMapper;
    }


    public AssetsResponseDto execute(DeprecationDto deprecationDto) {

        return assetsMapper.toDto(calculateDeprecationService.execute(deprecationDto.getActualDate(), deprecationDto.getDeprecationPercentage(), deprecationDto.getSerial()));
    }
}
