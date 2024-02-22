package com.zara.product.outbound.database.entity;

import com.zara.product.model.Price;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigInteger;
import java.time.LocalDateTime;
@Entity(name = "prices")
public record PriceSpringJpaEntity(
    @Id
    @GeneratedValue
    Long id,
    @Column(name = "brand_id")
    @NotEmpty
    BigInteger brandId,
    @Column(name = "start_date")
    @NotEmpty
    LocalDateTime startDate,
    @Column(name = "end_date")
    @NotEmpty
    LocalDateTime endDate,
    @Column(name = "price_list")
    @NotEmpty
    BigInteger priceList,
    @Column(name = "product_id")
    @NotEmpty
    BigInteger productId,
    @Column(name = "priority")
    @NotEmpty
    int priority,
    @Column(name = "price")
    @NotEmpty
    Double price,
    @Column(name = "curr")
    @NotEmpty
    String curr)
{

    public PriceSpringJpaEntity() {
        this(0L,BigInteger.ZERO,LocalDateTime.now(),LocalDateTime.now(),BigInteger.ZERO,BigInteger.ZERO,0,0.0,"");
    }

    public Price toDomainModel(){
        return new Price(id,brandId,startDate,endDate,priceList,productId,priority,price,curr);
    }
}
