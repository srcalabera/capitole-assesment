package com.zara.product.outbound.database;

import com.zara.product.outbound.database.entity.PriceSpringJpaEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;
@Hidden
@Repository
public interface PriceSpringJpaRepository extends JpaRepository<PriceSpringJpaEntity, Long> {

    Optional<PriceSpringJpaEntity> findFirstByProductIdAndBrandIdAndStartDateIsLessThanEqualAndEndDateIsGreaterThanEqualOrderByPriorityDesc(
            BigInteger productId,
            BigInteger brandId,
            LocalDateTime dateForStart,
            LocalDateTime dateForEnd
    );
}