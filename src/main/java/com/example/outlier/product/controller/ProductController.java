package com.example.outlier.product.controller;


import com.example.outlier.product.dto.ProductDto;
import com.example.outlier.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getProduct(){
        return new ResponseEntity<>(productService.getProductList(), HttpStatus.OK);
    }
    @GetMapping("{productName}")
    public ResponseEntity<ProductDto> getProductByName(@PathVariable String productName){
        return new ResponseEntity<>(productService.getProductByName(productName),HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<ProductDto> insertProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.insertProduct(productDto),HttpStatus.OK);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable long productId){
        return new ResponseEntity<>(productService.deleteProduct(productId),HttpStatus.OK);
    }
    @PatchMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable long productId, @RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.updateProduct(productId,productDto),HttpStatus.OK);
    }

}
