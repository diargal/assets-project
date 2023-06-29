package com.analista.desarrollo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssetsResponseDto {
    private String serial;
    private String name;
    private String purchaseDate;
    private Double purchaseCost;
    private Double deprecation;
    private Boolean isEnabled;
}
