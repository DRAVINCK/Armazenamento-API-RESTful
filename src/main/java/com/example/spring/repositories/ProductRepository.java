package com.example.spring.repositories;

import com.example.spring.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository //não á necessidade quando se estende JpaRepository
public interface ProductRepository  extends JpaRepository<ProductModel, UUID> {

}
