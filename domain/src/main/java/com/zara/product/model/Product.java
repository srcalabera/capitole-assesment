package com.zara.product.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

public record Product(
    BigInteger brandId,
    LocalDateTime startDate,
    LocalDateTime endDate,
    BigInteger priceList,
    BigInteger productId,
    Double price
){}