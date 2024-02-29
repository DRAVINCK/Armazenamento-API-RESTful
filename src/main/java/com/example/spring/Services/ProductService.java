package com.example.spring.Services;

import com.example.spring.Mappers.ProductMapper;
import com.example.spring.controllers.ProductController;
import com.example.spring.controllers.dtos.ProductRecordDto;
import com.example.spring.models.ProductModel;
import com.example.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductModel saveProduct(ProductRecordDto productRecordDto) {
        ProductModel productModel = productMapper.dtoToEntity(productRecordDto);
        return productRepository.save(productModel);
    }

    public List<ProductModel> getAllProducts() {
        List<ProductModel> productList = productRepository.findAll();
        productList.forEach(product -> product.add(linkTo(methodOn(ProductController.class).
                getOneProduct(product.getIdProduct())).withSelfRel()));
        return productList;
    }

    public Optional<ProductModel> getOneProduct(UUID id) {
        return productRepository.findById(id);
    }

    public ProductModel updateProduct(UUID id, ProductRecordDto productRecordDto) {
        Optional<ProductModel> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            ProductModel productModel = productOptional.get();
            productMapper.dtoToEntity(productRecordDto);
            return productRepository.save(productModel);
        }
        return null;
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }


}
