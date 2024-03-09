package com.example.spring.Mappers;

import com.example.spring.controllers.dtos.StoredItemRecordDto;
import com.example.spring.models.StoredItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoredItemMapper {

    StoredItemMapper INSTANCE = Mappers.getMapper(StoredItemMapper.class);

    @Mapping(target = "storageId", ignore = true)
    StoredItemModel dtoToEntity(StoredItemRecordDto itemDto);

    StoredItemRecordDto entityToDto(StoredItemModel storedItemEntity);
}
