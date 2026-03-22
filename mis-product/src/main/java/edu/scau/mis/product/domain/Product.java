package edu.scau.mis.product.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(description = "商品对象（粗）")
public class Product {
    private Long productId;
    private String productSn;
    private String productName;
    private Long categoryId;
    private BigDecimal displayPrice;
    private String productDesc;
    private String mainImage;
    private String detailImages;    // JSON 字符串
    private Integer productStock;
    private String productStatus;   // onsale / offshelf
    private String stockStatus;     // normal / running_low / out_of_stock
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}