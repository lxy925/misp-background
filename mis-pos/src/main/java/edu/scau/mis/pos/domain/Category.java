package edu.scau.mis.pos.domain;
import edu.scau.mis.common.domain.BaseEntity;

import java.io.Serializable;

public class Category extends BaseEntity implements Serializable {
    private Long categoryId;
    private Long parentId;
    private String categoryName;

    public Category() {
    }
    public Category(Long categoryId, Long parentId, String categoryName) {
        this.categoryId = categoryId;
        this.parentId = parentId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", parentId=" + parentId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
