package com.analista.desarrollo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeprecationDto {
    private LocalDate actualDate;
    private Double deprecationPercentage;
    private String serial;
}
