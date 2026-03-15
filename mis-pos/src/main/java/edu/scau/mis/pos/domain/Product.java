package edu.scau.mis.pos.domain;

import edu.scau.mis.common.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "商品传输对象")
public class Product extends BaseEntity implements Serializable {
    @Schema(description = "商品ID")
    private Long productId;
    @Schema(description = "商品编号")
    private String productSn;
    @Schema(description = "商品名称")
    private String productName;
    @Schema(description = "商品描述")
    private String productDescription;
    @Schema(description = "商品价格")
    private BigDecimal price;
    @Schema(description = "类别ID")
    private Long productCategoryId;
    @Schema(description = "类别")
    private Category category;
    @Schema(description = "主图URL")
    private String imageUrl;
    @Schema(description = "详情URL")
    private String detailUrl;
}
