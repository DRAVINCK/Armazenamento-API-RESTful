package com.example.spring.controllers.dtos;

import com.example.spring.models.CategoryModel;
import com.example.spring.models.StoredItemModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record StoredItemRecordDto(@NotBlank String productName,
                                  @NotNull BigDecimal storageValue,
                                  @NotNull CategoryModel categoryModel) {

    public static StoredItemRecordDto fromModel(StoredItemModel storedItemModel) {
        return new StoredItemRecordDto(
                storedItemModel.getProductModel().getName(),
                storedItemModel.getStorageValue(),
                storedItemModel.getProductModel().getCategoryModel()
        );
    }
}
