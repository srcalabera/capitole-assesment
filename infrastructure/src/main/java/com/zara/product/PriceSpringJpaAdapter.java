package com.zara.product;

import com.zara.product.model.Price;
import com.zara.product.port.PricePersistencePort;
import com.zara.product.outbound.database.PriceSpringJpaRepository;
import com.zara.product.outbound.database.entity.PriceSpringJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PriceSpringJpaAdapter implements PricePersistencePort {
    private final PriceSpringJpaRepository priceSpringJpaRepository;

    @Override
    public Optional<Price> findByProductAndBrandAndDate(BigInteger productId, BigInteger brandId, LocalDateTime date) {
        return priceSpringJpaRepository.findFirstByProductIdAndBrandIdAndStartDateIsLessThanEqualAndEndDateIsGreaterThanEqualOrderByPriorityDesc(
                productId,
                brandId,
                date,
                date
        ).map(PriceSpringJpaEntity::toDomainModel);
    }

}
