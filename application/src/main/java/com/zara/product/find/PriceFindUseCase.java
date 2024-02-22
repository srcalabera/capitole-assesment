package com.zara.product.find;

import com.zara.product.model.Price;
import com.zara.product.port.PricePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceFindUseCase {
    private final PricePersistencePort pricePersistencePort;
    public Price findProductDetail(BigInteger productId, BigInteger brandId, LocalDateTime date){
        return this.pricePersistencePort.findByProductAndBrandAndDate(productId,brandId,date).orElseThrow();
    }
}
