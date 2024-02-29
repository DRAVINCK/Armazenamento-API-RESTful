package com.example.spring.controllers;

import com.example.spring.Mappers.ProductMapper;
import com.example.spring.Services.ProductService;
import com.example.spring.controllers.dtos.ProductRecordDto;
import com.example.spring.models.ProductModel;
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
public class ProductController {

    @Autowired  
    ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto){
        ProductModel savedProduct = productService.saveProduct(productRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }


    @GetMapping("/products")
    public ResponseEntity<List<ProductRecordDto>> getAllProducts(){
        List<ProductModel> productList = productService.getAllProducts();
        List<ProductRecordDto> productDtoList = productList.stream()
                .map(ProductMapper.INSTANCE::entityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(productDtoList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable UUID id){
        Optional<ProductModel> productOptional = productService.getOneProduct(id);
        if (productOptional.isPresent()) {
            ProductRecordDto productDto = ProductMapper.INSTANCE.entityToDto(productOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(productDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable UUID id,
                                                @RequestBody @Valid ProductRecordDto productRecordDto){
        ProductModel updatedProduct = productService.updateProduct(id, productRecordDto);
        if (updatedProduct != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable UUID id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluído");
    }
}
