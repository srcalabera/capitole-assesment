package com.zara.product.outbound.database.entity;

import com.zara.product.model.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity(name = "products")
public class ProductSpringJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    Long id;
    @Column(name = "brand_id")
    @NotEmpty
    BigInteger brandId;
    @Column(name = "start_date")
    @NotEmpty
    LocalDateTime startDate;
    @Column(name = "end_date")
    @NotEmpty
    LocalDateTime endDate;
    @Column(name = "price_list")
    @NotEmpty
    BigInteger priceList;
    @Column(name = "product_id")
    @NotEmpty
    BigInteger productId;
    @Column(name = "priority")
    @NotEmpty
    int priority;
    @Column(name = "price")
    @NotEmpty
    Double price;
    @Column(name = "curr")
    @NotEmpty
    String curr;

    public ProductSpringJpaEntity() {
    }

    public ProductSpringJpaEntity(Long id, BigInteger brandId, LocalDateTime startDate, LocalDateTime endDate, BigInteger priceList, BigInteger productId, int priority, Double price, String curr) {
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    public Product toDomainModel() {
        return new Product( brandId, startDate, endDate, priceList, productId, price);
    }
}
