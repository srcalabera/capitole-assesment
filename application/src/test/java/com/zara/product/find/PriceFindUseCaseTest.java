package com.zara.product.find;

import com.zara.product.exception.NotFoundException;
import com.zara.product.model.Price;
import com.zara.product.port.PricePersistencePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PriceFindUseCaseTest {

    @InjectMocks
    public PriceFindUseCase priceFindUseCase;

    @Mock
    public PricePersistencePort pricePersistencePort;

    @Test
    public void testFindProductDetail() {

        var productId = java.math.BigInteger.valueOf(35455);
        var brandId = java.math.BigInteger.valueOf(1);
        var date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

        Mockito.when(pricePersistencePort.findByProductAndBrandAndDate(productId,brandId,date))
                .thenReturn(Optional.of(new Price(
                        0L,
                        brandId,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        java.math.BigInteger.valueOf(1),
                        productId,
                        1,
                        20.30,
                        "EUR"
                )));

        var result = priceFindUseCase.findProductDetail(productId,brandId,date);


        assertEquals(BigInteger.valueOf(1), result.priceList());
        assertEquals(productId, result.productId());
        assertEquals(brandId, result.brandId());
        assertEquals(20.30, result.price());

        Mockito.verify(pricePersistencePort).findByProductAndBrandAndDate(productId,brandId,date);
    }

    @Test
    public void testFindProductDetailException()  {

        var productId = java.math.BigInteger.valueOf(35455);
        var brandId = java.math.BigInteger.valueOf(1);
        var date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

        Mockito.when(pricePersistencePort.findByProductAndBrandAndDate(productId,brandId,date))
                .thenReturn(Optional.empty());

        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            priceFindUseCase.findProductDetail(productId,brandId,date);
        }, "");

        Assertions.assertEquals("Product Not Found please provide other information", thrown.getErrorMessage());

    }
}