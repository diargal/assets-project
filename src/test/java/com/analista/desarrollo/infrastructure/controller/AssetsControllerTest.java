package com.analista.desarrollo.infrastructure.controller;

import com.analista.desarrollo.AnalistaDesarrolloApplication;
import com.analista.desarrollo.application.dto.AssetsRequestDto;
import com.analista.desarrollo.application.dto.DeprecationDto;
import com.analista.desarrollo.domain.dataBuilder.AssetsRequestTestDataBuilder;
import com.analista.desarrollo.domain.dataBuilder.AssetsTestDataBuilder;
import com.analista.desarrollo.domain.model.Assets;
import com.analista.desarrollo.domain.port.CreateAssetsRepository;
import com.analista.desarrollo.domain.port.FindAssetsRepository;
import com.analista.desarrollo.domain.port.UpdateAssetsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = {AnalistaDesarrolloApplication.class})
class AssetsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CreateAssetsRepository createAssetsRepository;
    @MockBean
    private FindAssetsRepository findAssetsRepository;
    @MockBean
    private UpdateAssetsRepository updateAssetsRepository;


    @Test
    void getCorrectDeprecationValueTest() throws Exception {
        String serial = "QWAS213ED4";
        Assets assets = new AssetsTestDataBuilder().fully().build();
        Double deprecationPercentage = 0.04;
        DeprecationDto deprecationDto = new DeprecationDto(LocalDate.of(2025, 1, 1), deprecationPercentage, serial);

        Mockito.when(findAssetsRepository.execute(serial)).thenReturn(assets);

        mockMvc.perform(post("/api/assets/deprecation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(deprecationDto)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.deprecation").value(assets.getDeprecation()));
    }

    @Test
    void updateAssetsSuccessTest() throws Exception {
        Assets assets = new AssetsTestDataBuilder().fully().build();
        AssetsRequestDto assetsRequestDto = new AssetsRequestTestDataBuilder().fully().build();

        Mockito.when(updateAssetsRepository.execute(Mockito.any(), Mockito.anyString())).thenReturn(assets);

        mockMvc.perform(put("/api/assets?serial=QWAS213ED4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(assetsRequestDto)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.serial").value(assets.getSerial()));
    }

    @Test
    void createAssetsSuccessTest() throws Exception {
        AssetsRequestDto assetsRequestDto = new AssetsRequestTestDataBuilder().fully().build();
        Assets assets = new AssetsTestDataBuilder().fully().build();

        Mockito.when(createAssetsRepository.execute(Mockito.any())).thenReturn(assets);

        mockMvc.perform(post("/api/assets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(assetsRequestDto)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.serial").value(assets.getSerial()));
    }

}