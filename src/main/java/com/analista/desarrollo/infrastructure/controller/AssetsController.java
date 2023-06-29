package com.analista.desarrollo.infrastructure.controller;

import com.analista.desarrollo.application.dto.AssetsRequestDto;
import com.analista.desarrollo.application.dto.AssetsResponseDto;
import com.analista.desarrollo.application.dto.DeprecationDto;
import com.analista.desarrollo.application.handler.CalculateDeprecationHandler;
import com.analista.desarrollo.application.handler.CreateAssetsHandler;
import com.analista.desarrollo.application.handler.UpdateAssetsHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assets")
public class AssetsController {
    private final CalculateDeprecationHandler calculateDeprecationHandler;
    private final CreateAssetsHandler createAssetsHandler;
    private final UpdateAssetsHandler updateAssetsHandler;

    public AssetsController(CalculateDeprecationHandler calculateDeprecationHandler, CreateAssetsHandler createAssetsHandler, UpdateAssetsHandler updateAssetsHandler) {
        this.calculateDeprecationHandler = calculateDeprecationHandler;
        this.createAssetsHandler = createAssetsHandler;
        this.updateAssetsHandler = updateAssetsHandler;
    }

    @PostMapping
    public ResponseEntity<AssetsResponseDto> createAssets(
            @RequestBody AssetsRequestDto assetsRequestDto
    ) {
        return ResponseEntity.ok(createAssetsHandler.execute(assetsRequestDto));
    }

    @PutMapping
    public ResponseEntity<AssetsResponseDto> updateAssets(
            @RequestBody AssetsRequestDto assetsRequestDto, @RequestParam String serial
    ) {
        return ResponseEntity.ok(updateAssetsHandler.execute(assetsRequestDto, serial));
    }

    @PostMapping(path = "/deprecation")
    public ResponseEntity<AssetsResponseDto> calculateDeprecation(
            @RequestBody DeprecationDto deprecationDto
    ) {
        return ResponseEntity.ok(calculateDeprecationHandler.execute(deprecationDto));
    }
}
