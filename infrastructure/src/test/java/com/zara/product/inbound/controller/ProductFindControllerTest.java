package com.zara.product.inbound.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zara.product.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductFindControllerTest {

    private static final String PRODUCT_PATH = "/product";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void getProductInformation() throws Exception {
        var productId = java.math.BigInteger.valueOf(35455);
        var brandId = java.math.BigInteger.valueOf(1);
        var date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

        MvcResult result = this.mockMvc.perform(get(PRODUCT_PATH + "/" + productId)
                        .param("brandId", String.valueOf(brandId))
                        .param("date", String.valueOf(date)))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        var price = objectMapper.readValue(responseContent, Product.class);

        assertEquals(BigInteger.valueOf(1), price.priceList());
        assertEquals(productId, price.productId());
        assertEquals(brandId, price.brandId());
        assertEquals(35.50, price.price());

    }

    @Test
    @DisplayName("petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void getProductInformation2() throws Exception {
        var productId = java.math.BigInteger.valueOf(35455);
        var brandId = java.math.BigInteger.valueOf(1);
        var date = LocalDateTime.of(2020, 6, 14, 16, 0, 0);

        MvcResult result = this.mockMvc.perform(get(PRODUCT_PATH + "/" + productId)
                        .param("brandId", String.valueOf(brandId))
                        .param("date", String.valueOf(date)))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        var price = objectMapper.readValue(responseContent, Product.class);

        assertEquals(BigInteger.valueOf(2), price.priceList());
        assertEquals(productId, price.productId());
        assertEquals(brandId, price.brandId());
        assertEquals(25.45, price.price());

    }

    @Test
    @DisplayName("petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void getProductInformation3() throws Exception {
        var productId = java.math.BigInteger.valueOf(35455);
        var brandId = java.math.BigInteger.valueOf(1);
        var date = LocalDateTime.of(2020, 6, 14, 21, 0, 0);

        MvcResult result = this.mockMvc.perform(get(PRODUCT_PATH + "/" + productId)
                        .param("brandId", String.valueOf(brandId))
                        .param("date", String.valueOf(date)))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        var price = objectMapper.readValue(responseContent, Product.class);

        assertEquals(BigInteger.valueOf(1), price.priceList());
        assertEquals(productId, price.productId());
        assertEquals(brandId, price.brandId());
        assertEquals(35.50, price.price());

    }

    @Test
    @DisplayName("petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    public void getProductInformation4() throws Exception {
        var productId = java.math.BigInteger.valueOf(35455);
        var brandId = java.math.BigInteger.valueOf(1);
        var date = LocalDateTime.of(2020, 6, 15, 10, 0, 0);

        MvcResult result = this.mockMvc.perform(get(PRODUCT_PATH + "/" + productId)
                        .param("brandId", String.valueOf(brandId))
                        .param("date", String.valueOf(date)))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        var price = objectMapper.readValue(responseContent, Product.class);

        assertEquals(BigInteger.valueOf(3), price.priceList());
        assertEquals(productId, price.productId());
        assertEquals(brandId, price.brandId());
        assertEquals(30.50, price.price());

    }

    @Test
    @DisplayName("petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    public void getProductInformation5() throws Exception {
        var productId = java.math.BigInteger.valueOf(35455);
        var brandId = java.math.BigInteger.valueOf(1);
        var date = LocalDateTime.of(2020, 6, 16, 21, 0, 0);

        MvcResult result = this.mockMvc.perform(get(PRODUCT_PATH + "/" + productId)
                        .param("brandId", String.valueOf(brandId))
                        .param("date", String.valueOf(date)))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        var price = objectMapper.readValue(responseContent, Product.class);

        assertEquals(BigInteger.valueOf(4), price.priceList());
        assertEquals(productId, price.productId());
        assertEquals(brandId, price.brandId());
        assertEquals(38.95, price.price());

    }

    @Test
    @DisplayName("cuando el producto no existe para la brand 1 (ZARA)")
    public void getProductInformation6() throws Exception {
        var productId = java.math.BigInteger.valueOf(35456);
        var brandId = java.math.BigInteger.valueOf(1);
        var date = LocalDateTime.of(2020, 6, 16, 21, 0, 0);

        this.mockMvc.perform(get(PRODUCT_PATH + "/" + productId)
                        .param("brandId", String.valueOf(brandId))
                        .param("date", String.valueOf(date)))
                .andExpect(status().isNotFound())
                .andReturn();

    }
}