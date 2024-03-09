package com.example.spring.Mappers;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MappingConfig {

    @Bean
    public ProductMapper productMapper(){
        return Mappers.getMapper(ProductMapper.class);
    }

    @Bean
    public StoredItemMapper storedItemMapper(){return Mappers.getMapper(StoredItemMapper.class);}
}
