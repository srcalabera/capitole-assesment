package com.zara.product.port;

import com.zara.product.model.Price;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PricePersistencePort {
    Optional<Price> findByProductAndBrandAndDate(BigInteger productId, BigInteger brandId, LocalDateTime date);
}