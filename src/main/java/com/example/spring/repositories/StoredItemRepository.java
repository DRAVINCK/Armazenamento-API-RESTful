package com.example.spring.repositories;

import com.example.spring.models.StoredItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StoredItemRepository extends JpaRepository<StoredItemModel, UUID> {

    Optional<StoredItemModel> findById(UUID id);

    void deleteById(UUID id);
}
