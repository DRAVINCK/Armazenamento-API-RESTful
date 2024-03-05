package com.example.spring.models;

import jakarta.persistence.*;
import org.springframework.hateoas.Link;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "stored_items")
public class StoredItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID storageId; // ID do depósito onde o item está armazenado

    @OneToOne
    @JoinColumn(name = "product_id") // Nome da coluna que representa o ID do produto na tabela de stored_items
    private ProductModel productModel;
    private BigDecimal storageValue; // Valor de armazenamento do item


    public UUID getStorageId() {
        return storageId;
    }

    public void setStorageId(UUID storageId) {
        this.storageId = storageId;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public BigDecimal getStorageValue() {
        return storageValue = productModel.getValue().multiply(BigDecimal.valueOf(0.18));
    }

}
