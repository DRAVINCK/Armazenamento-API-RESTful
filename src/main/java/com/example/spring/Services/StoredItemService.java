package com.example.spring.Services;

import com.example.spring.Mappers.StoredItemMapper;
import com.example.spring.controllers.StoredItemController;
import com.example.spring.controllers.dtos.StoredItemRecordDto;
import com.example.spring.models.StoredItemModel;
import com.example.spring.repositories.StoredItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import org.springframework.hateoas.Link;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public CollectionModel<EntityModel<StoredItemModel>> getAllItems() {
        List<StoredItemModel> storedItemModelList = storedItemRepository.findAll();
        storedItemModelList.forEach(item -> item.add(WebMvcLinkBuilder.linkTo(StoredItemController.class).slash(item.getStorageId()).withSelfRel()));
        return CollectionModel.of(storedItemModelList);
    }

    public Optional<StoredItemModel> getOneItem(UUID id) {
        return storedItemRepository.findById(id);
    }

    public StoredItemModel updateItem(UUID id, StoredItemRecordDto storedItemRecordDto) {
        Optional<StoredItemModel> itemOptional = storedItemRepository.findById(id);
        if (itemOptional.isPresent()) {
            StoredItemModel storedItemModel = itemOptional.get();
            storedItemMapper.updateEntityFromDto(storedItemRecordDto, storedItemModel);
            return storedItemRepository.save(storedItemModel);
        }
        return null;
    }

    public void deleteItem(UUID id) {
        storedItemRepository.deleteById(id);
    }
}
