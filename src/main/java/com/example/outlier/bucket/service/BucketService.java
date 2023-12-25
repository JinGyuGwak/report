package com.example.outlier.bucket.service;


import com.example.outlier.bucket.dto.BucketDto;
import com.example.outlier.bucket.dto.GetBucketRes;
import com.example.outlier.bucket.repository.BucketRepository;
import com.example.outlier.user.dto.UserDto;
import com.example.outlier.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BucketService {
    private final BucketRepository bucketRepository;
    private final UserRepository userRepository;
//    static String name = SecurityContextHolder.getContext().getAuthentication().getName();


    @Transactional
    public String insertBucket(BucketDto bucketDto, long productId){
        try {
            UserDto user = userRepository.getUserByEmail(getLoginEmail());
            bucketRepository.insertBucket(bucketDto,user.getId(),productId);
            return "장바구니 추가 완료";
        } catch (Exception e){
            throw new IllegalArgumentException("장바구니 추가에 실패하였습니다.");
        }
    }

    @Transactional
    public String deleteAllBucket(){
        try {
            UserDto user = userRepository.getUserByEmail(getLoginEmail());
            bucketRepository.deleteAllBucket(user.getId());
            return "장바구니 비우기 완료";
        } catch (Exception e){
            throw new IllegalArgumentException("장바구니 전체 비우기에 실패하였습니다.");
        }
    }

    @Transactional
    public String deleteBucketById(List<Long> idList) {
        try {
            bucketRepository.deleteBucket(idList);
            return "삭제완료";
        } catch (Exception e){
            throw new IllegalArgumentException("장바구니 목록 선택 삭제에 실패하였습니다.");
        }
    }

    @Transactional(readOnly = true)
    public List<GetBucketRes> getBucket() {
        try {
            UserDto user = userRepository.getUserByEmail(getLoginEmail());
            return bucketRepository.getBucketList(user.getId());
        } catch (Exception e){
            throw new IllegalArgumentException("장바구니 목록 조회에 실패하였습니다.");
        }
    }
    public static String getLoginEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            throw new IllegalArgumentException("인증 정보가 잘못되었습니다.");
        }
        return authentication.getName();
    }

}
