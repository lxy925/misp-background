package edu.scau.mis.product.service;

import com.github.pagehelper.PageInfo;
import edu.scau.mis.product.domain.Category;
import edu.scau.mis.product.domain.CategoryTreeNode;


import java.util.List;

public interface ICategoryService {
    /**
     * 根据id查询类别
     * @param categoryId 类别id
     * @return 类别对象
     */
    Category getCategoryById(Long categoryId);
    /**
     * 查询所有类别
     * @return 类别列表
     */
    List<Category> getAllCategories();

    /**
     * 查询类别树
     * @return
     */

    List<CategoryTreeNode> getCategoriesTree();

    PageInfo<Category> selectCategoryList(Category category);

    int insertCategory(Category category);

    int updateCategory(Category category);

    int deleteCategoryById(Long categoryId);

    int deleteCategoryByIds(Long[] categoryIds);
}
