package com.example.outlier.bucket.dto;


import com.example.outlier.product.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBucketRes {
    private Long id;
    private int count;
    private String userName;
    private List<ProductDto> productDto;
}
