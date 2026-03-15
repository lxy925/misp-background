package edu.scau.mis.pos.service.impl;

import edu.scau.mis.pos.domain.Category;
import edu.scau.mis.pos.domain.CategoryTreeNode;
import edu.scau.mis.pos.mapper.ICategoryMapper;
import edu.scau.mis.pos.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryMapper categoryMapper;
    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryMapper.selectCategoryById(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryMapper.selectAllCategoryList();
    }

    /**
     * 查询类别树
     *
     * @return
     */
    @Override
    public List<CategoryTreeNode> getCategoriesTree() {
        List<Category> allCategories = getAllCategories();
        if (allCategories == null || allCategories.isEmpty()) {
            return Collections.emptyList();
        }
        Map<Long, CategoryTreeNode> nodeMap = new HashMap<>();
        for (Category category : allCategories) {
            CategoryTreeNode node = new CategoryTreeNode(category.getCategoryId(), category.getCategoryName());
            nodeMap.put(category.getCategoryId(), node);
        }
        List<CategoryTreeNode> rootNodes = new ArrayList<>();
        for (Category category : allCategories) {
            Long categoryId = category.getCategoryId();
            Long parentId = category.getParentId();
            CategoryTreeNode currentNode = nodeMap.get(categoryId);
            if (parentId == null || parentId == 0) {
                rootNodes.add(currentNode);
            } else {
                CategoryTreeNode parentNode = nodeMap.get(parentId);
                if (parentNode != null) {
                    if (parentNode.getChildren() == null) {
                        parentNode.setChildren(new ArrayList<>());
                    }
                    parentNode.getChildren().add(currentNode);
                } else {
                    rootNodes.add(currentNode);
                }
            }
        }
        sortTree(rootNodes);
        return rootNodes;
    }

    /**
     * 树形数据排序
     * @param nodes
     */
    private void sortTree(List<CategoryTreeNode> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return;
        }
        nodes.sort(Comparator.comparing(CategoryTreeNode::getValue));
        for (CategoryTreeNode node : nodes) {
            sortTree(node.getChildren());
        }
    }
}
