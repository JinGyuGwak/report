package com.example.outlier.buy.service;

import com.example.outlier.bucket.dto.BucketDto;
import com.example.outlier.buy.dto.BuyDto;
import com.example.outlier.buy.repository.BuyRepository;
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
public class BuyService {
    private final BuyRepository buyRepository;
    private final UserRepository userRepository;

    @Transactional
    public String insertBuy() {
        try {
            UserDto user = userRepository.getUserByEmail(getLoginEmail());
            List<BucketDto> bucketDtoList = buyRepository.selectBucketByUserId(user.getId());

            if(!bucketDtoList.isEmpty()){
                for(BucketDto bucket : bucketDtoList){
                    buyRepository.insertBuy(bucket);
                }
                buyRepository.deleteBucketsByUserId(user.getId());
            }
            return "구매 완료!";
        } catch (Exception e){
            throw new IllegalArgumentException("상품 구매에 실패하였습니다.");
        }
    }

    @Transactional(readOnly = true)
    public List<BuyDto> getBuy() {
        try {
            UserDto user = userRepository.getUserByEmail(getLoginEmail());
            return buyRepository.getBuy(user.getId());
        } catch (Exception e){
            throw new IllegalArgumentException("구매목록 조회에 실패하였습니다.");
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
