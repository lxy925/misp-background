package edu.scau.mis.pos.domain;

import edu.scau.mis.common.domain.BaseEntity;
import edu.scau.mis.common.domain.BaseEntity;
import edu.scau.mis.pos.enums.ProductStatusEnum;
import edu.scau.mis.pos.enums.StockStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class PetFood extends BaseEntity {

    private Integer foodId;
    private String productName;
    private Integer categoryId;
    private BigDecimal price;
    private Integer stock;
    private ProductStatusEnum status;
    private StockStatusEnum stockStatus;
}