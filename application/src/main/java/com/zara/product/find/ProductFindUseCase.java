package com.zara.product.find;

import com.zara.product.exception.ProductNotFoundException;
import com.zara.product.model.Product;
import com.zara.product.port.ProductPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductFindUseCase {
    private final ProductPersistencePort productPersistencePort;
    public Product findProductDetail(BigInteger productId, BigInteger brandId, LocalDateTime date){
        return this.productPersistencePort.findByProductAndBrandAndDate(productId,brandId,date)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product Not Found please provide other information")
                );
    }
}
