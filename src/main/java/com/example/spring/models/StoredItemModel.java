package com.example.spring.models;

import jakarta.persistence.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "stored_items")
public class StoredItemModel extends RepresentationModel<StoredItemModel> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID storageId;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductModel productModel;
    private BigDecimal storageValue;


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

    public void setStorageValue(BigDecimal storageValue) {
        this.storageValue = storageValue;
    }

    public BigDecimal getStorageValue() {
        return storageValue;
    }

}
