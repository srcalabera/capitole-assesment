package com.zara.product;

import com.zara.product.model.Product;
import com.zara.product.port.ProductPersistencePort;
import com.zara.product.outbound.database.ProductSpringJpaRepository;
import com.zara.product.outbound.database.entity.ProductSpringJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductSpringJpaAdapter implements ProductPersistencePort {
    private final ProductSpringJpaRepository productSpringJpaRepository;

    @Override
    public Optional<Product> findByProductAndBrandAndDate(BigInteger productId, BigInteger brandId, LocalDateTime date) {
        return productSpringJpaRepository.findFirstByProductIdAndBrandIdAndStartDateIsLessThanEqualAndEndDateIsGreaterThanEqualOrderByPriorityDesc(
                productId,
                brandId,
                date,
                date
        ).map(ProductSpringJpaEntity::toDomainModel);
    }

}
