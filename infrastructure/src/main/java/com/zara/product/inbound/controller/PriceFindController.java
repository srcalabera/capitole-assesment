package com.zara.product.inbound.controller;

import com.zara.product.find.PriceFindUseCase;
import com.zara.product.model.Price;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(
            summary = "Get Product Information",
            description = "Get Product information by brand and certain date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product Information", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Price.class)) }),
            @ApiResponse(responseCode = "500", description = "An error occured.", content = @Content) })

    public ResponseEntity findAllPosts(
             @PathVariable BigInteger productId, @RequestParam BigInteger brandId,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date){
        log.info("findAllPosts : productId [" + productId +"] brandId [" + brandId + "] date [" + date + "]" );
        return ResponseEntity.ok(this.priceFindUseCase.findProductDetail(productId,brandId,date));
    }
}