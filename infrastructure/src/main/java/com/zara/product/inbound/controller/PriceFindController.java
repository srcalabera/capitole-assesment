package com.zara.product.inbound.controller;

import com.zara.product.find.PriceFindUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class PriceFindController {


    private final PriceFindUseCase priceFindUseCase;

    @GetMapping("/{productId}")
    public ResponseEntity findAllPosts(@PathVariable BigInteger productId, @RequestParam BigInteger brandId,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date){
        log.info("findAllPosts : productId [" + productId +"] brandId [" + brandId + "] date [" + date + "]" );
        return ResponseEntity.ok(this.priceFindUseCase.findProductDetail(productId,brandId,date));
    }
}