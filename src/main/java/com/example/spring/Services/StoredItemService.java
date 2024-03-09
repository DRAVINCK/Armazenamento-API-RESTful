package com.example.spring.Services;

import com.example.spring.Mappers.StoredItemMapper;
import com.example.spring.controllers.ProductController;
import com.example.spring.controllers.StoredItemController;
import com.example.spring.controllers.dtos.StoredItemRecordDto;
import com.example.spring.models.StoredItemModel;
import com.example.spring.repositories.StoredItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class StoredItemService {

    @Autowired
    private StoredItemRepository storedItemRepository;

    @Autowired
    private StoredItemMapper storedItemMapper;

    public StoredItemModel saveItem(StoredItemRecordDto storedItemRecordDto) {
        StoredItemModel storedItemModel = storedItemMapper.dtoToEntity(storedItemRecordDto);
        return storedItemRepository.save(storedItemModel);
    }

    public List<StoredItemModel> getAllStoredItems(){
        List<StoredItemModel> storedItemList = storedItemRepository.findAll();
        storedItemList.forEach(storedItem -> storedItem.add(
                linkTo(methodOn(StoredItemController.class).getOneStoredItem(storedItem.getStorageId())).withSelfRel()));

        return storedItemList;
    }

    public Optional<StoredItemModel> getOneItem(UUID id) {
        return storedItemRepository.findById(id);
    }

    public StoredItemModel updateItem(UUID id, StoredItemRecordDto storedItemRecordDto) {
        Optional<StoredItemModel> itemOptional = storedItemRepository.findById(id);
        if (itemOptional.isPresent()) {
            StoredItemModel storedItemModel = itemOptional.get();
            storedItemMapper.entityToDto(storedItemModel);
            return storedItemRepository.save(storedItemModel);
        }
        return null;
    }

    public void deleteItem(UUID id) {
        storedItemRepository.deleteById(id);
    }
}
