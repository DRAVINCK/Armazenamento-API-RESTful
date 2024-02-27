package com.example.spring.controllers.dtos;

import com.example.spring.models.CategoryModel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record ProductRecordDto(@NotBlank String name,
                               @NotNull BigDecimal value,
                               @Enumerated(EnumType.STRING) CategoryModel categoryModel) {

}
