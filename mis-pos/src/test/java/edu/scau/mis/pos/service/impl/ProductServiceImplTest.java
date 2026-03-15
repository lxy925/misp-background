package edu.scau.mis.pos.service.impl;

import edu.scau.mis.pos.domain.Product;
import edu.scau.mis.pos.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {edu.scau.mis.PosTestApplication.class})
@ActiveProfiles("test")
class ProductServiceImplTest {
    @Autowired
    private IProductService productService;

    @Test
    void getProductById() {
        Product product = productService.getProductById(1L);
        assertEquals("1001", product.getProductSn());
    }

    @Test
    void getProductBySn() {
        Product product = productService.getProductBySn("1002");
        System.out.println(product);
        assertEquals(2L, product.getProductId(), "测试不通过");
    }

}