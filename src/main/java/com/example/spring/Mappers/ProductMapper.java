package com.example.spring.Mappers;

import com.example.spring.controllers.dtos.ProductRecordDto;
import com.example.spring.models.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "idProduct", ignore = true) // Ignorar mapeamento para o ID, pois será gerado automaticamente
    ProductModel dtoToEntity(ProductRecordDto productDto);

    ProductRecordDto entityToDto(ProductModel productEntity);
}
