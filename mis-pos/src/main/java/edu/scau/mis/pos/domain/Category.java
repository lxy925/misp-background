package edu.scau.mis.pos.domain;
import edu.scau.mis.common.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import java.io.Serializable;
@Data
@Schema(description = "商品类别传输对象")
public class Category extends BaseEntity implements Serializable {

    @Schema(description = "商品类别ID")
    private Long categoryId;
    @Schema(description = "商品类别父节点ID")
    private Long parentId;
    @Schema(description = "商品类别名称")
    private String categoryName;
    @Schema(description = "商品类别级别")
    private Integer level;
    @Schema(description = "商品类别层级路径")
    private String path;
    @Schema(description = "商品类别上架状态，true已上架false未上架")
    private Boolean state;
    @Schema(description = "页码")
    private Integer pageNum;

    @Schema(description = "每页条数")
    private Integer pageSize;
}
