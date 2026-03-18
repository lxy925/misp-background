package edu.scau.mis.pos.domain;

import edu.scau.mis.common.domain.BaseEntity;
import edu.scau.mis.pos.enums.ProductStatusEnum;
import edu.scau.mis.pos.enums.StockStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

/**
 * 宠物服装商品实体类
 * 对应数据库表：pet_clothing
 */
@Data
// 生成 equals() 和 hashCode() 时，把父类 BaseEntity 的字段也算进去
// 如果不加这个，两个对象比较时会忽略 createTime 等审计字段，Lombok 也会报警告
@EqualsAndHashCode(callSuper = true)
public class PetClothing extends BaseEntity {

    /** 服装ID，主键自增 */
    private Integer clothingId;

    /** 商品名称 */
    private String productName;

    /** 分类ID，关联分类表 */
    private Integer categoryId;

    /** 售价 */
    private BigDecimal price;

    /** 库存数量 */
    private Integer stock;

    /** 上架状态：active=上架，inactive=下架 */
    private ProductStatusEnum status;

    /** 库存状态：normal=正常，out_of_stock=缺货，running_low=库存紧张 */
    private StockStatusEnum stockStatus;
}