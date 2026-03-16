package edu.scau.mis.pos.service.impl;

import edu.scau.mis.pos.domain.Category;
import edu.scau.mis.pos.domain.CategoryTreeNode;
import edu.scau.mis.pos.mapper.ICategoryMapper;
import edu.scau.mis.pos.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryMapper categoryMapper;

    /**
     * 根据ID查询分类
     */
    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryMapper.selectCategoryById(categoryId);
    }

    /**
     * 查询所有分类
     */
    @Override
    public List<Category> getAllCategories() {
        // 传入空对象 = 查询所有
        return categoryMapper.selectCategoryList(new Category());
    }

    /**
     * 条件查询分类列表
     */
    @Override
    public List<Category> selectCategoryList(Category category) {
        return categoryMapper.selectCategoryList(category);
    }

    /**
     * 新增分类
     */
    @Override
    public int insertCategory(Category category) {
        return categoryMapper.insertCategory(category);
    }

    /**
     * 修改分类
     */
    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }

    /**
     * 单条删除分类
     */
    @Override
    public int deleteCategoryById(Long categoryId) {
        return categoryMapper.deleteCategoryById(categoryId);
    }

    /**
     * 批量删除分类
     */
    @Override
    public int deleteCategoryByIds(Long[] categoryIds) {
        return categoryMapper.deleteCategoryByIds(categoryIds);
    }

    /**
     * 查询类别树
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