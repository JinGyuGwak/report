package com.example.outlier.bucket.controller;


import com.example.outlier.bucket.dto.BucketDto;
import com.example.outlier.bucket.dto.GetBucketRes;
import com.example.outlier.bucket.service.BucketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bucket")
public class BucketController {
    private final BucketService bucketService;

    @PostMapping("/{productId}")
    public ResponseEntity<String> insertBucket(@PathVariable long productId,
                                               @RequestBody BucketDto bucketDto){
        return new ResponseEntity<>(bucketService.insertBucket(bucketDto,productId),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<GetBucketRes>> getBucket(){
        return new ResponseEntity<>(bucketService.getBucket(),HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteBucketById(@RequestBody List<Long> idList){
        return new ResponseEntity<>(bucketService.deleteBucketById(idList), HttpStatus.OK);
    }
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllBucket(){
        return new ResponseEntity<>(bucketService.deleteAllBucket(),HttpStatus.OK);
    }

}
