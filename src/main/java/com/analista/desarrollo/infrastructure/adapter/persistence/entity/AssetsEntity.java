package com.analista.desarrollo.infrastructure.adapter.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;


@Data
@Table(name = "assets")
@Entity
public class AssetsEntity {
    @Id
    private String serial;
    private String name;
    private LocalDate purchaseDate;
    private Double purchaseCost;
    private Double deprecation;
    private Boolean isEnabled;
}
