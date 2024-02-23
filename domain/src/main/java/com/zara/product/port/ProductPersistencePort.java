package com.zara.product.port;

import com.zara.product.model.Product;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductPersistencePort {
    Optional<Product> findByProductAndBrandAndDate(BigInteger productId, BigInteger brandId, LocalDateTime date);
}