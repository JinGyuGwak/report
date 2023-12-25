package com.example.outlier.product.repository;

import com.example.outlier.product.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductRepository {

    List<ProductDto> getProductList();
    ProductDto getProductByName(String name);
    void deleteProduct(long productId);
    void insertProduct(ProductDto productDto);
    void updateProduct(@Param("id")long id, @Param("productDto")ProductDto productDto);

}
