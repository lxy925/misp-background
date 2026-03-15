package edu.scau.mis.pos.domain;

import lombok.Data;

import java.util.List;
@Data
public class CategoryTreeNode {
    private Long value;
    private String label;
    private List<CategoryTreeNode> children;
    public CategoryTreeNode(Long value, String label) {
        this.value = value;
        this.label = label;
    }
}
