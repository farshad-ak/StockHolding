package com.commercetools.farshad.stockhandling.stock;


import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import com.commercetools.farshad.stockhandling.product.Product;
import com.commercetools.farshad.stockhandling.stock.dto.ProductStockModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class StockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockService stockService;

    @Test
    void testSave() {

    }

    @Test
    @DisplayName("GET /stock?productId=1 - Found")
    void testGetProductInStock() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        ProductStockModel productStockModel = new ProductStockModel("1", new Date(), null);

        doReturn(productStockModel).when(stockService).getProductInStock("1");
        mockMvc.perform(get("/stock").param("productId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

                .andExpect(jsonPath("$.productId",is("1")));

    }

    @Test
    @DisplayName("GET /stock?productId=1 - Not Found")
    void testGetProductInStock_NotFound() throws Exception {

        doReturn(null).when(stockService).getProductInStock("2");
        mockMvc.perform(get("/stock").param("productId", "2"))
                .andExpect(status().isNotFound());

    }

    @Test
    void getStockStatistic() {


    }
}