package com.example.outlier.bucket.repository;


import com.example.outlier.bucket.dto.BucketDto;
import com.example.outlier.bucket.dto.GetBucketRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BucketRepository {
    void insertBucket(@Param("bucketDto")BucketDto bucketDto,
                      @Param("userId")long userId,
                      @Param("productId")long productId);
    List<GetBucketRes> getBucketList(long userId);
    void deleteBucket(List<Long> bucketId);
    void deleteAllBucket(long userId);

}
