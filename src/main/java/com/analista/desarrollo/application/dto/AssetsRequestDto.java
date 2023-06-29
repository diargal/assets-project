package com.analista.desarrollo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetsRequestDto {
    private String serial;
    private String name;
    private LocalDate purchaseDate;
    private Double purchaseCost;
    private Boolean isEnabled;
}
