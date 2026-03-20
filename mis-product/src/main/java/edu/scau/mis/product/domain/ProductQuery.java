package edu.scau.mis.product.domain;
import edu.scau.mis.common.domain.PageQuery;
import lombok.Data;

import java.util.List;

/**
 * 商品查询条件（纯业务）
 */
@Data
public class ProductQuery extends PageQuery {
    // 商品名称
    private String productName;
    // 商品编码
    private String productSn;
    // 分类ID
    private List<Long> categoryIds;
    // 状态 0-下架 1-上架
    // private Integer status;
}