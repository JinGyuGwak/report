package com.example.outlier.bucket.dto;


import com.example.outlier.product.dto.ProductDto;
import com.example.outlier.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BucketDto {
    private Long id;
    private int count;

    private Long productId;
    private Long userId;


}
