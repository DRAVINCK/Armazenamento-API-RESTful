package com.example.spring.controllers.dtos;

import com.example.spring.models.CategoryModel;
import com.example.spring.models.StoredItemModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record StoredItemRecordDto(@NotBlank String productName,
                                  @NotNull BigDecimal storageValue,
                                  @Valid @NotNull CategoryModel categoryModel) {



    public static StoredItemRecordDto fromModel(StoredItemModel storedItemModel) {
        if (storedItemModel == null) {
            return null;
        }

        return new StoredItemRecordDto(
                storedItemModel.getProductModel() != null ? storedItemModel.getProductModel().getName() : null,
                storedItemModel.getStorageValue(),
                storedItemModel.getProductModel() != null ? storedItemModel.getProductModel().getCategoryModel() : null
        );
    }
}
