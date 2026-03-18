package edu.scau.mis.pos.mapper;

import edu.scau.mis.MisBootApplication;
import edu.scau.mis.pos.domain.Product;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true) // 必需设为false，即测试会更新数据库
@ContextConfiguration(classes = MisBootApplication.class)
class IProductMapperTest {
    @Autowired
    private IProductMapper productMapper;

    @Test
    void selectProductById() {
        Product product = productMapper.selectProductById(1L);
        assertEquals("钢笔", product.getProductName());
    }

    @Test
    void selectProductBySn() {
        Product product = productMapper.selectProductBySn("1001");
        assertEquals("钢笔", product.getProductName());
    }

    @Test
    void selectProductList() {
        Product product = new Product();
        product.setProductName("笔");
        product.setProductSn("1001");
        product.setProductCategoryId(1L);
        List<Product> products = productMapper.selectProductList(product);
        assertEquals(1, products.size());
    }

    @Test
    void selectAllProductList() {
        List<Product> products = productMapper.selectAllProductList();
        assertEquals(10, products.size());
    }

    @Test
    void selectProductByNameAndCategoryId() {
        List<Product> products = productMapper.selectProductByNameAndCategoryId("笔", 1L);
        assertEquals(2, products.size());
    }

    @Test
    void insertProduct() {
        Product product = new Product();
        product.setProductSn("1011");
        product.setProductName("牙膏");
        product.setProductDescription("黑人牙膏越刷越白");
        product.setPrice(new BigDecimal("10.00"));
        product.setProductCategoryId(2L);
        product.setImageUrl("https://www.baidu.com");
        product.setDetailUrl("https://www.baidu.com");
        productMapper.insertProduct(product);
        assertEquals("牙膏", productMapper.selectProductBySn("1011").getProductName());
    }

    @Test
    void updateProduct() {
        Product product = new Product();
        product.setProductId(11L);
        product.setProductName("牙刷");
        productMapper.updateProduct(product);
        assertEquals("牙刷", productMapper.selectProductBySn("1011").getProductName());
    }

    @Test
    void deleteProductById() {
        productMapper.deleteProductById(11L);
        assertNull(productMapper.selectProductBySn("1011"));
    }

    @Test
    void deleteProductByIds() {
        Product product1 = new Product();
        product1.setProductSn("1012");
        product1.setProductName("沐浴露");
        product1.setProductDescription("洗去疲惫");
        product1.setProductCategoryId(2L);
        product1.setPrice(new BigDecimal("10.00"));
        productMapper.insertProduct(product1);
        Product product2 = new Product();
        product2.setProductSn("1013");
        product2.setProductName("洗发水");
        product2.setProductDescription("清爽无刺激");
        product2.setProductCategoryId(2L);
        product2.setPrice(new BigDecimal("20.00"));
        productMapper.insertProduct(product2);
        productMapper.deleteProductByIds(new Long[]{product1.getProductId(), product2.getProductId()});
        assertEquals(10, productMapper.selectAllProductList().size());
    }
}