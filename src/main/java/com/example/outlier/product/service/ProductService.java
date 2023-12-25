package com.example.outlier.product.service;


import com.example.outlier.product.dto.ProductDto;
import com.example.outlier.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDto> getProductList() {
        try{
            return productRepository.getProductList();
        } catch (Exception exception){
            throw new IllegalArgumentException("상품 목록 조회에 실패하였습니다.");
        }
    }

    @Transactional(readOnly = true)
    public ProductDto getProductByName(String productName) {
        try {
            return productRepository.getProductByName(productName);
        } catch (Exception e){
            throw new IllegalArgumentException("상품명을 통한 조회에 실패하였습니다.");
        }
    }

    @Transactional
    public ProductDto insertProduct(ProductDto productDto) {
        try {
            productRepository.insertProduct(productDto);
            return productDto;
        } catch (Exception e){
            throw new IllegalArgumentException("상품 등록에 실패하였습니다.");
        }
    }

    @Transactional
    public String deleteProduct(long productId) {
        try {
            productRepository.deleteProduct(productId);
            return "상품삭제완료!";
        } catch (Exception e){
            throw new IllegalArgumentException("상품 삭제에 실패하였습니다.");
        }
    }

    @Transactional
    public ProductDto updateProduct(long productId, ProductDto productDto) {
        try {
            productRepository.updateProduct(productId,productDto);
            return productDto;
        } catch (Exception e){
            throw new IllegalArgumentException("상품목록 수정에 실패하였습니다.");
        }
    }
}
