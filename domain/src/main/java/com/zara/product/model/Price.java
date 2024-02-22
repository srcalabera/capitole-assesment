package com.zara.product.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

public record Price (
    Long id,
    BigInteger brandId,
    LocalDateTime startDate,
    LocalDateTime endDate,
    BigInteger priceList,
    BigInteger productId,
    int priority,
    Double price,
    String curr
){}