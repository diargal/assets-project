package com.analista.desarrollo.infrastructure.config;

import com.analista.desarrollo.domain.port.CreateAssetsRepository;
import com.analista.desarrollo.domain.port.FindAssetsRepository;
import com.analista.desarrollo.domain.port.UpdateAssetsRepository;
import com.analista.desarrollo.domain.service.CalculateDeprecationService;
import com.analista.desarrollo.domain.service.CreateAssetsService;
import com.analista.desarrollo.domain.service.UpdateAssetsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateAssetsService createAssetsService(CreateAssetsRepository createAssetsRepository) {
        return new CreateAssetsService(createAssetsRepository);
    }

    @Bean
    public UpdateAssetsService updateAssetsService(UpdateAssetsRepository updateAssetsRepository) {
        return new UpdateAssetsService(updateAssetsRepository);
    }

    @Bean
    public CalculateDeprecationService calculateDeprecationService(FindAssetsRepository assetsRepository) {
        return new CalculateDeprecationService(assetsRepository);
    }
}
