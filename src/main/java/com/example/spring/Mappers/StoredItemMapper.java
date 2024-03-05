package com.example.spring.Mappers;

import com.example.spring.controllers.dtos.StoredItemRecordDto;
import com.example.spring.models.StoredItemModel;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface StoredItemMapper {

    StoredItemMapper INSTANCE = Mappers.getMapper(StoredItemMapper.class);

    @Mapping(target = "idStoredItem", ignore = true)
    StoredItemModel dtoToEntity(StoredItemRecordDto itemDto);

    StoredItemRecordDto entityToDto(StoredItemRecordDto itemEntity);
}
