package com.example.outlier.buy.controller;


import com.example.outlier.buy.dto.BuyDto;
import com.example.outlier.buy.service.BuyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/buy")
public class BuyController {
    private final BuyService buyService;

    @PostMapping("")
    public ResponseEntity<String> insertBuy(){
        return new ResponseEntity<>(buyService.insertBuy(), HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<BuyDto>> getBuy(){
        return new ResponseEntity<>(buyService.getBuy(), HttpStatus.OK);
    }
}
