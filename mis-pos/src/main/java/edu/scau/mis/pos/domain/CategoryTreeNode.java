package edu.scau.mis.pos.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;

/**
 * 商品分类树形结构节点
 * 用于前端展示分类层级关系
 */
@Data
@Schema(description = "商品分类树节点")
public class CategoryTreeNode {

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

    @Schema(description = "子分类列表")
    private List<CategoryTreeNode> children;
    /**
     * 全参构造函数：直接传入Category，自动赋值所有属性
     */
    public CategoryTreeNode(Category category) {
        this.categoryId = category.getCategoryId();
        this.parentId = category.getParentId();
        this.categoryName = category.getCategoryName();
        this.level = category.getLevel();
        this.path = category.getPath();
        this.state = category.getState();
    }
}