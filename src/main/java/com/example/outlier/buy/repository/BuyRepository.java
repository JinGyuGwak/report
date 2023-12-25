package com.example.outlier.buy.repository;


import com.example.outlier.bucket.dto.BucketDto;
import com.example.outlier.buy.dto.BuyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BuyRepository {
    List<BucketDto> selectBucketByUserId(@Param("userId") long userId);
    void insertBuy(BucketDto bucket);
    void deleteBucketsByUserId(@Param("userId") long userId);

    List<BuyDto> getBuy(@Param("userId") long userId);
}
