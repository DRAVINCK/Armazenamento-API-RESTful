package com.example.spring.controllers;

import com.example.spring.Mappers.StoredItemMapper;
import com.example.spring.Services.StoredItemService;
import com.example.spring.controllers.dtos.StoredItemRecordDto;
import com.example.spring.models.StoredItemModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class StoredItemController {

    @Autowired
    StoredItemService storedItemService;

    @Autowired
    private StoredItemMapper storedItemMapper;

    @PostMapping("/storedItem")
    public ResponseEntity<StoredItemModel> saveStoredItem(@RequestBody @Valid StoredItemRecordDto storedItemRecordDto){
        StoredItemModel savedStoredItem = storedItemService.saveItem(storedItemRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStoredItem);
    }

    @GetMapping("/storedItem")
    public ResponseEntity<List<StoredItemRecordDto>> getAllStoredItems(){
        List<StoredItemModel> storedItemModelList = storedItemService.getAllStoredItems();
        List<StoredItemRecordDto> storedItemRecordDtoList = storedItemModelList.stream()
                .map(StoredItemMapper.INSTANCE::entityToDto).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(storedItemRecordDtoList);
    }

    @GetMapping("/storedItem/{id}")
    public ResponseEntity<Object> getOneStoredItem(@PathVariable UUID id){
        Optional<StoredItemModel> storedItemModelOptional = storedItemService.getOneItem(id);
        if (storedItemModelOptional.isPresent()) {
            StoredItemRecordDto storedItemRecordDto = StoredItemMapper.INSTANCE.entityToDto(storedItemModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(storedItemRecordDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não encontrado.");
        }
    }

    @PutMapping("/storedItem/{id}")
    public ResponseEntity<Object> updateStoredItem(@PathVariable UUID id, @RequestBody @Valid StoredItemRecordDto storedItemRecordDto){
        StoredItemModel updateItem = storedItemService.updateItem(id,storedItemRecordDto);
        if(updateItem != null){
            return ResponseEntity.status(HttpStatus.OK).body(updateItem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não econtrado");
        }
    }

}
