package com.zara.product.find;

import com.zara.product.exception.ProductNotFoundException;
import com.zara.product.model.Product;
import com.zara.product.port.ProductPersistencePort;
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
class ProductFindUseCaseTest {

    @InjectMocks
    public ProductFindUseCase productFindUseCase;

    @Mock
    public ProductPersistencePort productPersistencePort;

    @Test
    public void testFindProductDetail() {

        var productId = java.math.BigInteger.valueOf(35455);
        var brandId = java.math.BigInteger.valueOf(1);
        var date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

        Mockito.when(productPersistencePort.findByProductAndBrandAndDate(productId,brandId,date))
                .thenReturn(Optional.of(new Product(
                        brandId,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        java.math.BigInteger.valueOf(1),
                        productId,
                        20.30
                )));

        var result = productFindUseCase.findProductDetail(productId,brandId,date);


        assertEquals(BigInteger.valueOf(1), result.priceList());
        assertEquals(productId, result.productId());
        assertEquals(brandId, result.brandId());
        assertEquals(20.30, result.price());

        Mockito.verify(productPersistencePort).findByProductAndBrandAndDate(productId,brandId,date);
    }

    @Test
    public void testFindProductDetailException()  {

        var productId = java.math.BigInteger.valueOf(35455);
        var brandId = java.math.BigInteger.valueOf(1);
        var date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

        Mockito.when(productPersistencePort.findByProductAndBrandAndDate(productId,brandId,date))
                .thenReturn(Optional.empty());

        ProductNotFoundException thrown = Assertions.assertThrows(ProductNotFoundException.class, () -> {
            productFindUseCase.findProductDetail(productId,brandId,date);
        }, "");

        Assertions.assertEquals("Product Not Found please provide other information", thrown.getErrorMessage());

    }
}